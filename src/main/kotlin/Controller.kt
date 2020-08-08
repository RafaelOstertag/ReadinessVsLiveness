package ch.guengel.readinessvsliveness

import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class Controller {
    @GetMapping("/readiness")
    fun getReadiness(): ResponseEntity<Boolean> {
        val ok = State.ready.get()
        logger.info("Set readiness to {}", ok)

        if (ok) {
            return ResponseEntity.ok(ok)
        }

        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(ok)
    }

    @PutMapping("/readiness")
    fun setReadiness(@RequestBody enabledDisable: EnableDisable) = State.ready.set(enabledDisable.enabled)

    @GetMapping("/liveness")
    fun getLiveness(): ResponseEntity<Boolean> {
        val ok = State.live.get()
        logger.info("Set liveness to {}", ok)

        if (ok) {
            return ResponseEntity.ok(ok)
        }

        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(ok)
    }

    @PutMapping("/liveness")
    fun setLiveness(@RequestBody enabledDisable: EnableDisable) = State.live.set(enabledDisable.enabled)

    private companion object {
        private val logger = LoggerFactory.getLogger(Controller::class.java)
    }
}

data class EnableDisable(val enabled: Boolean)