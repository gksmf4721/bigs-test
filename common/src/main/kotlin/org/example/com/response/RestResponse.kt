package org.example.com.response

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import org.springframework.format.annotation.DateTimeFormat
import java.time.LocalDateTime

@JsonInclude(JsonInclude.Include.NON_NULL)
class RestResponse<T> {

    constructor(data: T) {
        this.data = data
    }

    // 결과 코드
    @JsonProperty("resultCode")
    private var resultCode: String = "00"

    // 요청 일시
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonFormat(shape = JsonFormat.Shape.STRING, timezone = "Asia/Seoul", pattern = "yyyy-MM-dd HH:mm:ss")
    private var resultDate: LocalDateTime = LocalDateTime.now()

    // 데이터
    @JsonProperty("items")
    private var data: T? = null

    class RestResultResponse {

        constructor(resultCode: String?, resultMsg: String?) {
            this.resultCode = resultCode
            this.resultMsg = resultMsg
        }

        @JsonProperty("resultCode")
        private var resultCode: String? = "00"

        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
        @JsonFormat(shape = JsonFormat.Shape.STRING, timezone = "Asia/Seoul", pattern = "yyyy-MM-dd HH:mm:ss")
        private var resultDate: LocalDateTime = LocalDateTime.now()

        @JsonProperty("resultMsg")
        private var resultMsg: String? = "";

    }
}