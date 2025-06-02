package com.simon.dragoneclipse.card_service.repository

import com.simon.dragoneclipse.card_service.model.mystling.MystlingType
import com.simon.dragoneclipse.card_service.model.mystling.MystlingTypeName
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MystlingTypeRepository: JpaRepository<MystlingType, MystlingTypeName>