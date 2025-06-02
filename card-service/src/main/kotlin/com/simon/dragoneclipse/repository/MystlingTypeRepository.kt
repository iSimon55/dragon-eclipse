package com.simon.dragoneclipse.repository

import com.simon.dragoneclipse.model.mystling.Mystling
import com.simon.dragoneclipse.model.mystling.MystlingType
import com.simon.dragoneclipse.model.mystling.MystlingTypeName
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MystlingTypeRepository: JpaRepository<MystlingType, MystlingTypeName>