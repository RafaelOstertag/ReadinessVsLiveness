package ch.guengel.readinessvsliveness

import java.util.concurrent.atomic.AtomicBoolean

object State {
    val ready = AtomicBoolean(true)
    val live = AtomicBoolean(true)
}