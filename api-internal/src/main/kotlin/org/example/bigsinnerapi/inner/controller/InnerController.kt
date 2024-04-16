package org.example.bigsinnerapi.inner.controller

import org.example.bigsinnerapi.inner.service.InnerService
import org.example.domain.vo.ForecastVO
import org.example.response.RestResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1")
class InnerController {

    @Autowired
    private lateinit var innerService: InnerService

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