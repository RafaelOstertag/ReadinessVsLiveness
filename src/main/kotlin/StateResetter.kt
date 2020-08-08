package ch.guengel.readinessvsliveness

import org.slf4j.LoggerFactory
import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

@Component
@EnableScheduling
class StateResetter {
    @Scheduled(fixedRate=30_000)
    fun resetReadiness() {
        logger.info("Reset ready state")
        State.ready.set(true)
    }

    private companion object {
        private val logger = LoggerFactory.getLogger(StateResetter::class.java)
    }
}