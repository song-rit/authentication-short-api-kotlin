package com.example.demo.controller

import com.example.demo.controller.response.GreetingResponse
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class GreetingController {

    @RequestMapping(
            value=["/hello"]
    )
    fun hello(): GreetingResponse {
        return GreetingResponse("hello")
    }
}