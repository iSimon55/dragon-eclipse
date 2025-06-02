package com.simon.dragoneclipse.card_service.repository

import com.simon.dragoneclipse.card_service.model.mystling.Mystling
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MystlingRepository: JpaRepository<Mystling, String>