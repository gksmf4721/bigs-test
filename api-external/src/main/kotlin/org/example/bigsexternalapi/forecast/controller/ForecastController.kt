package org.example.bigsexternalapi.forecast.controller

import org.example.bigsexternalapi.forecast.service.ForecastService
import org.example.domain.vo.ForecastVO
import org.example.response.RestResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1")
class ForecastController {

    @Autowired
    private lateinit var forecastService : ForecastService

    /**
     * 공공 API 조회
     * @param requestBody
     * @return ResponseEntity<RestResponse.RestResultResponse>
     */
    @Throws(UnsupportedOperationException::class)
    @PostMapping("/forecast")
    fun getForecast(@RequestBody requestBody: ForecastVO.RequestForecastVO)
        : ResponseEntity<RestResponse.RestResultResponse> {

        val result = forecastService.setForecast(requestBody)

        return ResponseEntity.ok(
            RestResponse.RestResultResponse(result["resultCode"], result["resultMsg"]))
    }

}