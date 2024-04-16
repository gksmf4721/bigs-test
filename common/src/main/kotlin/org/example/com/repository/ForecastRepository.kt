package org.example.com.repository

import org.example.com.domain.entity.ForecastEntity
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Configuration
@Repository("forecastRepository")
interface ForecastRepository: JpaRepository<ForecastEntity,Long> {}