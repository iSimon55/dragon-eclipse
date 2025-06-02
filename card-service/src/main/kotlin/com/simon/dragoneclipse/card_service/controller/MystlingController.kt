package com.simon.dragoneclipse.card_service.controller

import com.simon.dragoneclipse.card_service.dto.CreateMystlingRequest
import com.simon.dragoneclipse.card_service.model.mystling.Mystling
import com.simon.dragoneclipse.card_service.service.MystlingService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/mystlings")
data class MystlingController(
    val mystlingService: MystlingService
){
    @GetMapping
    fun getAllMystlings() = mystlingService.getAllMystlings()

    @GetMapping("/{name}")
    fun getMystlingByName(@PathVariable name: String) = mystlingService.getMystlingByName(name)

    @PostMapping
    fun createMystling(@RequestBody request: CreateMystlingRequest): ResponseEntity<Mystling> {
        val Mystling = mystlingService.createMystling(request)
        return ResponseEntity.status(HttpStatus.CREATED).body(Mystling)
    }

    @DeleteMapping("/{name}")
    fun deleteMystling(@PathVariable name: String) = mystlingService.deleteMystling(name)
}
