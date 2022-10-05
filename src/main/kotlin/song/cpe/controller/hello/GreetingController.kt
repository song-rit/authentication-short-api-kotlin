package song.cpe.controller.hello

import song.cpe.controller.hello.model.response.GreetingResponse
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/hello")
class GreetingController {

    @RequestMapping(
            value=["/greeting"]
    )
    fun hello(): GreetingResponse {
        return GreetingResponse("hello")
    }
}