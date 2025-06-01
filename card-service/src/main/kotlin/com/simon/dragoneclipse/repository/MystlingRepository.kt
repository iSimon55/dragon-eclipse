package com.simon.dragoneclipse.repository

import com.simon.dragoneclipse.model.Mystling
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MystlingRepository: JpaRepository<Mystling, String>