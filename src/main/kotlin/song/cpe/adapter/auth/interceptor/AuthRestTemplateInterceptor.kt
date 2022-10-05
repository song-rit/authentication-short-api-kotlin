package song.cpe.adapter.auth.interceptor

import org.slf4j.LoggerFactory
import org.springframework.http.HttpRequest
import org.springframework.http.HttpStatus
import org.springframework.http.client.ClientHttpRequestExecution
import org.springframework.http.client.ClientHttpRequestInterceptor
import org.springframework.http.client.ClientHttpResponse
import org.springframework.stereotype.Component
import org.springframework.util.StreamUtils
import org.springframework.web.bind.annotation.ExceptionHandler
import song.cpe.exception.exception.CommonException
import java.io.IOException
import java.nio.charset.Charset
import java.nio.charset.StandardCharsets.UTF_8
import kotlin.Throws

@Component
class AuthRestTemplateInterceptor : ClientHttpRequestInterceptor {

    companion object {
        private val logger = LoggerFactory.getLogger(AuthRestTemplateInterceptor::class.java)
    }

    @Throws(IOException::class)
    override fun intercept(
        request: HttpRequest,
        body: ByteArray,
        execution: ClientHttpRequestExecution
    ): ClientHttpResponse {
        return try {
            val response = execution.execute(request, body)
            log(request, body, response)
            response
        } catch (e: IOException) {
            logWhenException(request, body)
            throw e
        }
    }

    private fun logWhenException(request: HttpRequest, body: ByteArray) {
        logger.info("HTTP Request -> {}: {}", request.uri,  String(body, UTF_8));
    }

    @Throws(IOException::class, CommonException::class)
    private fun log(request: HttpRequest, body: ByteArray, response: ClientHttpResponse) {
        logger.info("HTTP Request -> {}: {}", request.uri, String(body, UTF_8));
        if (response.statusCode == HttpStatus.OK) {
            logger.info("HTTP Response -> {}: {}", request.uri,
            StreamUtils.copyToString(response.body, Charset.defaultCharset()))
        }
    }
}