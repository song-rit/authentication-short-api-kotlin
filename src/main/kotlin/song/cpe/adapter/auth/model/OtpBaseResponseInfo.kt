package song.cpe.adapter.auth.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class OtpBaseResponseInfo (
    private val code: String,
    private val message: String
)