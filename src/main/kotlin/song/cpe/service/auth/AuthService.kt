package song.cpe.service.auth

import org.springframework.stereotype.Service
import song.cpe.adapter.auth.AuthAdapter
import song.cpe.adapter.auth.model.AuthWithUserPasswordRequest
import song.cpe.controller.auth.model.auth.AuthRequest
import song.cpe.controller.auth.model.auth.AuthResponse
import song.cpe.service.auth.exception.UnAuthorizationException

@Service
class AuthService(
    private val authAdapter: AuthAdapter
) {

    fun auth(request: AuthRequest): AuthResponse {

        val authRequest = AuthWithUserPasswordRequest(
            username = request.username,
            password = request.password
        )
        val authInfo = authAdapter.authWithUsernamePassword(authRequest)

        return AuthResponse(
            accessToken = authInfo.message,
            refreshToken = authInfo.userId
        )
    }
}