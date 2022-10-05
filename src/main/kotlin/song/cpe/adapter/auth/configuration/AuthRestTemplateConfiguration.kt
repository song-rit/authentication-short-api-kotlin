package song.cpe.adapter.auth.configuration

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.client.BufferingClientHttpRequestFactory
import org.springframework.http.client.SimpleClientHttpRequestFactory
import org.springframework.http.converter.HttpMessageConverter
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter
import org.springframework.web.client.RestTemplate
import song.cpe.adapter.auth.interceptor.AuthRestTemplateInterceptor
import java.time.Duration
import java.util.*

@Configuration
class AuthRestTemplateConfiguration(
    private val objectMapper: ObjectMapper,
    private val authRestTemplateInterceptor: AuthRestTemplateInterceptor
) {
    @Bean("authRestTemplate")
    fun otpRestTemplate(): RestTemplate {
        val messageConverters: MutableList<HttpMessageConverter<*>> = ArrayList()
        val jsonMessageConverter = MappingJackson2HttpMessageConverter()
        messageConverters.add(jsonMessageConverter)
        jsonMessageConverter.objectMapper = objectMapper
        return RestTemplateBuilder()
            .requestFactory { BufferingClientHttpRequestFactory(SimpleClientHttpRequestFactory()) }
            .interceptors(authRestTemplateInterceptor)
            .messageConverters(messageConverters)
            .setReadTimeout(Duration.ofMillis(10000))
            .setConnectTimeout(Duration.ofMillis(10000))
            .build()
    }
}