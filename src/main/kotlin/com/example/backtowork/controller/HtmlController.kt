package com.example.backtowork.controller

import com.example.backtowork.Entry
import com.example.backtowork.Tasklist
import com.example.backtowork.Tree
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*
import java.util.*
import kotlin.collections.ArrayList


@RestController
class HtmlController {
    val phrases : MutableMap<Int, Tree<Tasklist>> = mutableMapOf()
    @GetMapping("/tasklist")
    fun backtowork(@RequestParam(required = false, defaultValue = "Ping") value: String): MutableCollection<ArrayList<Entry>> {
        val tree : Tree<String> = Tree("tasks")
        return phrases.values
    }

    @GetMapping("/tasklist/{id}")
    fun handler(@RequestParam(required = true, defaultValue = "0") task: String, @PathVariable id: String): Entry {
        return phrases[1]?.find {entry: Entry -> entry.id == UUID.fromString(id) } ?: Entry()
    }

    data class EntryRequest(val task: String, val date: Long, val userId: Int)
    @PostMapping("/tasklist")
    fun handler(@RequestBody request: EntryRequest): Entry {
        val entry = Entry(request.date, request.task)
        if (phrases.containsKey(request.userId)) {
            phrases[request.userId]!!.add(entry)
        } else {
            phrases[request.userId] = arrayListOf(entry)
        }
        return entry
    }


}