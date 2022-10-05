package song.cpe.adapter.auth

import com.fasterxml.jackson.databind.ObjectMapper
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.web.client.HttpClientErrorException
import org.springframework.web.client.RestTemplate
import song.cpe.adapter.auth.model.AuthWithPasswordResponse
import song.cpe.adapter.auth.model.AuthWithUserPasswordRequest
import song.cpe.service.auth.exception.UnAuthorizationException


@Service
class AuthAdapterImpl(
    private val authRestTemplate: RestTemplate
) : AuthAdapter {

    companion object {
        private val logger = LoggerFactory.getLogger(AuthAdapterImpl::class.java)
        private val objectMapper = ObjectMapper()
    }

    @Value("\${endpoint.auth}")
    lateinit var authUrl: String

    override fun authWithUsernamePassword(body: AuthWithUserPasswordRequest): AuthWithPasswordResponse {
        try {
            val request = HttpEntity(body, HttpHeaders())
            val response: ResponseEntity<AuthWithPasswordResponse> =
//                this.authRestTemplate.postForEntity(authUrl, request, String::class.java)
                authRestTemplate.postForEntity(authUrl, request, AuthWithPasswordResponse::class.java)
            if (response.statusCode != HttpStatus.OK && response.statusCode != HttpStatus.NO_CONTENT) {
                throw UnAuthorizationException()
            }
            return response.body!!
        } catch (ex: HttpClientErrorException) {
            throw UnAuthorizationException()
        }
    }
}