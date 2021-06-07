package io.edrb.jpatestingkotlin.repository

import io.edrb.jpatestingkotlin.entity.Device
import org.springframework.data.jpa.repository.JpaRepository

interface DeviceRepository: JpaRepository<Device, Long>