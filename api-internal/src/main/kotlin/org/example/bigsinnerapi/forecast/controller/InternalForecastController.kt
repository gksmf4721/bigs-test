package org.example.bigsinnerapi.forecast.controller

import org.example.bigsinnerapi.forecast.service.InternalForecastService
import org.example.com.response.RestResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1")
class InternalForecastController {

    @Autowired
    private lateinit var internalForecastService: InternalForecastService

    /**
     * DB 적재 예보 조회
     * @return ResponseEntity<out Any>
     */
    @GetMapping("/select")
    fun getForecast(): ResponseEntity<out Any> {

        val response = internalForecastService.getForecastList()

        return if (response.isNotEmpty()) {
            ResponseEntity.ok(RestResponse(response))
        } else {
            ResponseEntity.noContent().build();
        }
    }
}