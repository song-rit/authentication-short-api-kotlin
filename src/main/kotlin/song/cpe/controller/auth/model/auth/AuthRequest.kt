package song.cpe.controller.auth.model.auth

import com.fasterxml.jackson.annotation.JsonProperty


data class AuthRequest(
    @JsonProperty("client_id")
    val clientId: String,

    val username: String,

    val password: String,

    @JsonProperty("grant_type")
    val grantType: String,

    val scope: String
)