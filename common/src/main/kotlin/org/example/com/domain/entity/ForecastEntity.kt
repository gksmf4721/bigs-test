package org.example.com.domain.entity

import jakarta.persistence.*
import lombok.*
import org.hibernate.annotations.Comment

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Entity(name = "B_FORECAST")
data class ForecastEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FORECAST_SEQ")
    @Comment("예보 시퀀스")
    var forecastSeq: Long? = null,

    @Column(name = "BASE_DATE")
    @Comment("발표 일자")
    var baseDate: String? = null,

    @Column(name = "BASE_TIME")
    @Comment("발표 시각")
    var baseTime: String? = null,

    @Column(name = "CATEGORY")
    @Comment("자료구분코드")
    var category: String? = null,

    @Column(name = "NX")
    @Comment("예보지점 X 좌표")
    var nx: Int? = null,

    @Column(name = "NY")
    @Comment("예보지점 Y 좌표")
    var ny: Int? = null,

    @Column(name = "OBSR_VALUE")
    @Comment("실황 값")
    var obsrValue: String? = null
)
