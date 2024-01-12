package com.example.backtowork
import java.util.Date
class Tasklist(){
    private val entries: ArrayList<Entry> = arrayListOf()
    fun add(entry: Entry) {
        entries.add(entry)
    }

    fun get(
        date: Date = Date(0),
        index: Int = 0,
        filter: () -> Unit,
    ): ArrayList<Entry> {

        return arrayListOf()
    }
}