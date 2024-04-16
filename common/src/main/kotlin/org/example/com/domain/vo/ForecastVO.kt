package org.example.com.domain.vo

import lombok.*
import org.example.com.domain.entity.ForecastEntity

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
class ForecastVO {

    // 예보 요청 파라미터
    @Getter
    @Setter
    data class RequestForecastVO(
        var pageNo:     Int =       1,
        var numOfRows:  Int =       1000,
        var dateType:   String =    "JSON"
    )

    // DB 조회 반환 값
    @Getter
    @Setter
    data class ResponseForecastVO(
        var baseDate:   String? =   null,
        var baseTime:   String? =   null,
        var category:   String? =   null,
        var nx:         Int? =      null,
        var ny:         Int? =      null,
        var obsrValue:  String? =   null
    ) {

        fun toResponseOf(item: List<ForecastEntity>): List<ResponseForecastVO> {
            return item.map { item ->
                ResponseForecastVO(
                    baseDate =  item.baseDate,
                    baseTime =  item.baseTime,
                    category =  item.category,
                    nx =        item.nx,
                    ny =        item.ny,
                    obsrValue = item.obsrValue
                )
            }
        }
    }

}