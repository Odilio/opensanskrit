package br.com.sanscrito.sanscrito.adapters.config

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Scope
import org.springframework.context.annotation.ScopedProxyMode
import org.springframework.http.converter.HttpMessageConverter
import org.springframework.http.converter.ResourceHttpMessageConverter
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer
import java.text.SimpleDateFormat
import java.time.format.DateTimeFormatter

@Configuration
class WebConfig : WebMvcConfigurer {

    val dateTimeFormat = "yyyy-MM-dd HH:mm:ss"
    val dateFormat = "yyyy-MM-dd"

/* 
    override fun addInterceptors(registry: InterceptorRegistry) {
        registry.addInterceptor(clientRequestInterceptor())
    }

    @Bean(name = ["clientHeader"])
    @Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
    fun clientEntity(): ClientHeader = ClientHeader()

    @Bean
    fun clientRequestInterceptor(): ClientInterceptor = ClientInterceptor(clientEntity())
*/
    @Bean
    fun objectMapper(): ObjectMapper {
        return Jackson2ObjectMapperBuilder()
            .indentOutput(true)
            .dateFormat(SimpleDateFormat(dateFormat))
            .propertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE)
            .serializers(LocalDateSerializer(DateTimeFormatter.ofPattern(dateFormat)))
            .serializers(LocalDateTimeSerializer(DateTimeFormatter.ofPattern(dateTimeFormat)))
            .build()
    }

    override fun configureMessageConverters(converters: MutableList<HttpMessageConverter<*>>) {
        converters.add(MappingJackson2HttpMessageConverter(objectMapper()))
        converters.add(ResourceHttpMessageConverter())
    }
}
