package song.cpe.controller.auth.model.auth

import com.fasterxml.jackson.annotation.JsonProperty


data class AuthRequest(
        @JsonProperty("client_id")
        private val clientId: String,

        private val username: String,

        private val password: String,

        @JsonProperty("grant_type")
        private val grantType: String,

        private val scope: String
)