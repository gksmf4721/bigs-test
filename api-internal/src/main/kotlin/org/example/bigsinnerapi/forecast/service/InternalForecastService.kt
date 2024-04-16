package org.example.bigsinnerapi.forecast.service

import org.example.com.domain.vo.ForecastVO
import org.example.com.repository.ForecastRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class InternalForecastService {

    @Autowired
    private lateinit var forecastRepository: ForecastRepository

    fun getForecastList(): List<ForecastVO.ResponseForecastVO> {

        val result = forecastRepository.findAll();

        return ForecastVO.ResponseForecastVO().toResponseOf(result);
    }

}