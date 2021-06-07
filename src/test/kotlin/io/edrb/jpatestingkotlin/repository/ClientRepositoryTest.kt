package io.edrb.jpatestingkotlin.repository

import org.junit.jupiter.api.Test
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import kotlin.test.assertTrue

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ClientRepositoryTest(
    @Autowired private val clientRepository: ClientRepository
) {

    companion object {
        private val logger: Logger = LoggerFactory.getLogger(ClientRepositoryTest::class.java)
    }

    @Test
    internal fun `should be initialized`() {
        val client = clientRepository.findById(1)

        logger.info("${client.get()}")
        assertTrue {
            client.isPresent
        }


    }

    @Test
    internal fun `get children devices`() {
        val client = clientRepository.findById(1).get()

        logger.info("${client.devices}")
        assertTrue {
            client.devices.isNotEmpty()
        }
    }
}