package io.edrb.jpatestingkotlin.repository

import io.edrb.jpatestingkotlin.entity.Client
import io.edrb.jpatestingkotlin.entity.Device
import org.hibernate.proxy.HibernateProxy
import org.junit.jupiter.api.Test
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import kotlin.test.assertTrue

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class DeviceRepositoryTest(
    @Autowired private val deviceRepository: DeviceRepository,
    @Autowired private val clientRepository: ClientRepository
) {

    companion object {
        private val logger: Logger = LoggerFactory.getLogger(DeviceRepositoryTest::class.java)
    }

    @Test
    internal fun `should be initialized`() {
        val device = deviceRepository.findById(1)

        logger.info("${device.get()}")
        assertTrue {
            device.isPresent
        }
    }

    @Test
    internal fun `check lazy`() {
        val device = deviceRepository.findById(1).get()
        logger.info("Device ---- $device")

        val client = device.client
        logger.info("Client -> ${client::class.java}")

        assertTrue {
            HibernateProxy::class.java.isAssignableFrom(client::class.java)
        }
    }

    @Test
    internal fun `check copy`() {
        val device = deviceRepository.findById(1).get()

        assertTrue {
            device == device.copy()
        }
    }

    @Test
    internal fun `check hash code`() {
        val device = Device(
            name = "device-name"
        ).apply { client = clientRepository.getById(1) }

        val hashset = hashSetOf(device)

        logger.info("hashcode before storing -> ${device.hashCode()}")
        deviceRepository.save(device)
        logger.info("hashcode after storing -> ${device.hashCode()}")

        assertTrue { device in hashset }
    }
}