package song.cpe.controller.auth.model.auth

import com.fasterxml.jackson.annotation.JsonProperty

data class AuthResponse(
        @JsonProperty("access_token")
        val accessToken: String,

        @JsonProperty("refresh_token")
        val refreshToken: String
)