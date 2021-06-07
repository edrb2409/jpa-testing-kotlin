package io.edrb.jpatestingkotlin.repository

import io.edrb.jpatestingkotlin.entity.Client
import org.springframework.data.jpa.repository.JpaRepository

interface ClientRepository: JpaRepository<Client, Long>