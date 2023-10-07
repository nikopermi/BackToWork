package com.example.backtowork.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.*
import javax.lang.model.type.NullType



@Controller
class HtmlController {
    val phrases : MutableMap<Int, ArrayList<String>> = mutableMapOf<Int, ArrayList<String>>()
    @GetMapping("/")
    fun backtowork(model: Model): String {
        model["title"] = "hello world"
        model["post"] = ""
        return "index"
    }

    @PostMapping("/")
    fun handler(@RequestBody body: Map<String, String>, model: Model): String {
        model["title"] = "Post request"

        if(!body.containsKey("id") || !body.containsKey(("item"))) {
            model["post"] = "bad request $body"
        } else {
            val id = Integer.parseInt(body["id"])
            if(phrases.containsKey(id)) {
                phrases[id]!!.add(body["item"]!!)
            } else {
                phrases.put(id, arrayListOf(body["item"]!!))
            }
            model["post"] = phrases.toString()
            println(phrases)
        }
        return "index"
    }

    @GetMapping("/error")
    fun errorHandler(model: Model): String {
        return "error"
    }


}