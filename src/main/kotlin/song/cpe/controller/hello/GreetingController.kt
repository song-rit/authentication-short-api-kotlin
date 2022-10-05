package song.cpe.controller.hello

import song.cpe.controller.hello.model.response.GreetingResponse
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.slf4j.LoggerFactory

@RestController
@RequestMapping("/api/v1/hello")
class GreetingController {

    companion object {
        private val logger = LoggerFactory.getLogger(GreetingController::class.java)
    }

    @RequestMapping(
            value=["/greeting"]
    )
    fun hello(): GreetingResponse {
        val msg = "hello world"
        logger.info("greeting: {}", msg)
        return GreetingResponse(msg)
    }
}