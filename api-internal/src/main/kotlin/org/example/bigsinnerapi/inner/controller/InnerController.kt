package org.example.bigsinnerapi.inner.controller

import org.example.bigsinnerapi.inner.service.InnerService
import org.example.response.RestResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1")
class InnerController {

    @Autowired
    private lateinit var innerService: InnerService

    /**
     * DB 적재 예보 조회
     * @return ResponseEntity<out Any>
     */
    @GetMapping("/select")
    fun getForecast(): ResponseEntity<out Any> {

        val response = innerService.getForecastList()

        return if (response.isNotEmpty()) {
            ResponseEntity.ok(RestResponse(response))
        } else {
            ResponseEntity.noContent().build();
        }
    }
}