package org.example.bigsexternalapi.forecast.service


import org.example.domain.entity.ForecastEntity
import org.example.domain.vo.ForecastVO
import org.example.repository.ForecastRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import org.springframework.web.util.UriComponentsBuilder
import java.net.URI
import java.net.URLEncoder
import java.nio.charset.Charset
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Service
class ForecastService {

    @Autowired
    private lateinit var forecastRepository: ForecastRepository

    @Value("\${data.url}")
    val url : String = ""

    @Value("\${data.decodingKey}")
    val decodeServiceKey : String = ""

    @Value("\${bigs.x}")
    val x : Int = 0

    @Value("\${bigs.y}")
    val y : Int = 0


    @Throws(UnsupportedOperationException::class)
    fun setForecast(request: ForecastVO.RequestForecastVO): Map<String, String>? {

        val restTemplate = RestTemplate();
        val httpHeaders = HttpHeaders();
        httpHeaders.contentType = MediaType("application", "json", Charset.forName("UTF-8"))

        val date = getDate();
        val getUri = getUri(request.pageNo, request.numOfRows, request.dateType, date)

        // 공공 API 가져오기
        val response: Map<String, Any>? = restTemplate.getForObject(getUri, Map::class.java) as Map<String, Any>?
        val items = (response?.get("response") as? Map<String, Any>)?.get("body") as? Map<String, Any>?
        val itemList = items?.get("items") as? Map<String, Any>?
        var item = itemList?.get("item") as? List<Map<String, Object>>

        // Entity 삽입
        item?.let { insertForecast(item) }

        // resultCode, resultMsg 반환
        return (response?.get("response") as? Map<String, Any>)?.get("header") as? Map<String, String>?
    }

    // URI 반환
    fun getUri(pageNo: Int, numOfRows: Int, dataType: String, date: Map<String,String>): URI {

        val serviceKey = URLEncoder.encode(decodeServiceKey,"UTF-8")

        return UriComponentsBuilder.fromHttpUrl(url)
            .queryParam("serviceKey", serviceKey)
            .queryParam("pageNo", pageNo)
            .queryParam("numOfRows", numOfRows)
            .queryParam("dataType", dataType)
            .queryParam("base_date", date["base_date"])
            .queryParam("base_time", date["base_time"])
            .queryParam("nx", x)
            .queryParam("ny", y)
            .build(true)
            .toUri();
    }

    // 날짜, 시각 반환
    fun getDate(): Map<String, String> {

        val currentDate = LocalDateTime.now()
        val dateFormatter = DateTimeFormatter.ofPattern("yyyyMMdd")
        val timeFormatter = DateTimeFormatter.ofPattern("HHmm")

        return mapOf(
            "base_date" to currentDate.format(dateFormatter),
            "base_time" to currentDate.format(timeFormatter)
        )
    }

    // Jpa Save
    fun insertForecast(item : List<Map<String,Object>>) {

        val forecastEntities = item?.map { item ->
            ForecastEntity(
                baseDate =  item["baseDate"] as? String,
                baseTime =  item["baseTime"] as? String,
                category =  item["category"] as? String,
                nx =        item["nx"] as? Int,
                ny =        item["ny"] as? Int,
                obsrValue = item["obsrValue"] as? String
            )
        } ?: emptyList()
        forecastRepository.saveAll(forecastEntities);
    }
}