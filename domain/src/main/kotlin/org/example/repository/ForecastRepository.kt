package org.example.repository

import org.example.domain.entity.ForecastEntity
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Configuration
@Repository("forecastRepository")
interface ForecastRepository: JpaRepository<ForecastEntity,Long> {}