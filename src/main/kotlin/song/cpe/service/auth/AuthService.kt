package song.cpe.service.auth

import org.springframework.stereotype.Service
import song.cpe.controller.auth.model.auth.AuthRequest
import song.cpe.controller.auth.model.auth.AuthResponse
import song.cpe.service.auth.exception.UnAuthorizationException

@Service
class AuthService {

    fun auth(request: AuthRequest): AuthResponse {

        if(request.username == "test") {
            throw UnAuthorizationException()
        }

        return AuthResponse(
            accessToken = "",
            refreshToken = ""
        )
    }
}