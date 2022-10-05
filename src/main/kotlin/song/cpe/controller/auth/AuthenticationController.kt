package song.cpe.controller.auth

import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import song.cpe.controller.auth.model.auth.AuthRequest
import song.cpe.controller.auth.model.auth.AuthResponse


@RestController
@RequestMapping("/api/v1/oauth")
class AuthenticationController {

    @PostMapping(
            value = ["/auth"],
        consumes = [MediaType.APPLICATION_FORM_URLENCODED_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun auth(
        @RequestParam("client_id") clientId: String,
        @RequestParam("username") username: String,
        @RequestParam("password") password: String,
        @RequestParam("grant_type") grantType: String,
        @RequestParam("scope") scope: String
    ): ResponseEntity<AuthResponse> {
    val request = AuthRequest(
            clientId = clientId,
            username = username,
            password = password,
            grantType = grantType,
            scope = scope,
    )

        val response = AuthResponse(
                accessToken = "accessToken",
                refreshToken = "refreshToken"
        )
        return ResponseEntity<AuthResponse>(response, HttpStatus.OK)
    }
}