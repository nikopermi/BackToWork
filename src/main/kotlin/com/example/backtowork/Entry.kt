package com.example.backtowork

import java.time.LocalDate
import java.util.*

/*
    The Entry class represents a single entry in a Tasklist (maybe changed
    later to become more abstract as I start developing widgets)



    An Entry must have two fields:
       - Date log: Time that the Entry was created
       - String entry: What the Entry holds
 */
class Entry(
    val log: Long,
    val entry: String = "",
    val id: UUID = UUID.randomUUID(),
) {
    constructor() : this(0, "", UUID(0, 0))

}