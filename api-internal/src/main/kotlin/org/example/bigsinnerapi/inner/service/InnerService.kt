package org.example.bigsinnerapi.inner.service

import org.example.domain.vo.ForecastVO
import org.example.repository.ForecastRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class InnerService {

    @Autowired
    private lateinit var forecastRepository: ForecastRepository

    fun getForecastList(): List<ForecastVO.ResponseForecastVO> {

        val result = forecastRepository.findAll();

        return ForecastVO.ResponseForecastVO().toResponseOf(result);
    }

}