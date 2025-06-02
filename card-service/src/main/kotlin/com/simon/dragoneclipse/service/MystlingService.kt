package com.simon.dragoneclipse.service

import com.simon.dragoneclipse.dto.CreateMystlingRequest
import com.simon.dragoneclipse.model.mystling.Mystling
import com.simon.dragoneclipse.model.mystling.MystlingSpecialAbility
import com.simon.dragoneclipse.model.mystling.SubType
import com.simon.dragoneclipse.model.mystling.SubTypeId
import com.simon.dragoneclipse.repository.MystlingRepository
import com.simon.dragoneclipse.repository.MystlingTypeRepository
import org.springframework.stereotype.Service

@Service
class MystlingService(
    private val mystlingRepository: MystlingRepository,
    private val mystlingTypeRepository: MystlingTypeRepository
) {
    fun getAllMystlings() = mystlingRepository.findAll()

    fun getMystlingByName(name: String) = mystlingRepository.findById(name)

    fun createMystling(request: CreateMystlingRequest): Mystling {
        val mystlingType = mystlingTypeRepository.findById(request.type)
            .orElseThrow { IllegalArgumentException("Type not found: ${request.type}") }

        val tempMystling = Mystling(
            name = request.name,
            type = mystlingType,
            tokens = request.tokens,
            hp = request.hp,
            attack = request.attack,
            speed = request.speed,
            defense = request.defense,
            specialDefense = request.specialDefense,
            hpPvP = request.hpPvP,
            attackPvP = request.attackPvP,
            speedPvP = request.speedPvP,
            defensePvP = request.defensePvP,
            specialDefensePvP = request.specialDefensePvP,
            specialAbility = emptyList(), // tymczasowo pusto
            subType = emptyList(),        // tymczasowo pusto
            cards = emptyList()
        )

        val subTypes = request.subType?.map {
            val id = SubTypeId(request.name, it.type)
            SubType(id = id, mystling = tempMystling, cards = it.cards, tokens = it.tokens)
        } ?: listOf()

        val specialAbilities = request.specialAbility.map {
            MystlingSpecialAbility(
                name = it.name,
                mystling = tempMystling,
                cost = it.cost,
                effect = it.effect
            )
        }

        val finalMystling = tempMystling.copy(
            subType = subTypes,
            specialAbility = specialAbilities
        )

        return mystlingRepository.save(finalMystling)
    }


    fun deleteMystling(name: String) = mystlingRepository.deleteById(name)
}