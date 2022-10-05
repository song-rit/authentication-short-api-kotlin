package song.cpe.adapter.auth

import song.cpe.adapter.auth.model.AuthWithPasswordResponse
import song.cpe.adapter.auth.model.AuthWithUserPasswordRequest

interface AuthAdapter {
    fun authWithUsernamePassword(request: AuthWithUserPasswordRequest): AuthWithPasswordResponse
}