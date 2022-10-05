package song.cpe.adapter.auth.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class AuthWithUserPasswordRequest (
    val username: String,
    val password: String
)