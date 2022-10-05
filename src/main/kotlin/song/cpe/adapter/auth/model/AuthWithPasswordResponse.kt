package song.cpe.adapter.auth.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class AuthWithPasswordResponse (
    val code: String,
    val message: String,
    val userId: String

)