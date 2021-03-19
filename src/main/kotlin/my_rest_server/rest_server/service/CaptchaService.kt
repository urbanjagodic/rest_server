package my_rest_server.rest_server.service

import my_rest_server.rest_server.entity.CaptchaRequest
import my_rest_server.rest_server.entity.CaptchaResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import my_rest_server.rest_server.entity.User
import my_rest_server.rest_server.respository.UserRepository
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.web.client.RestTemplate
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.http.MediaType
import org.springframework.http.converter.FormHttpMessageConverter
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter
import org.springframework.util.LinkedMultiValueMap
import org.springframework.util.MultiValueMap
import org.springframework.http.converter.HttpMessageConverter
import java.util.*
import kotlin.collections.LinkedHashMap


@Service
class CaptchaService {

    @Autowired
    lateinit var userRepository : UserRepository

    @Value("\${app.captcha.url}")
    lateinit var URL : String

    @Value("\${app.captcha.secret}")
    lateinit var SECRET : String


    lateinit var restTemplate: RestTemplate

    init {
        restTemplate = RestTemplate()
    }


    fun validateCaptcha(token: String?) : CaptchaResponse {
        println("TOKEN: $token")
        println("URL: $URL")
        println("SECRET: $SECRET")

        var headers = HttpHeaders()
        headers.contentType = MediaType.MULTIPART_FORM_DATA

        var data = LinkedMultiValueMap<String, String>()
        data.add("secret", SECRET)
        data.add("response", token)
        val request = HttpEntity<LinkedMultiValueMap<String, String>>(data, headers)

        var response = restTemplate.postForObject(URL, request, CaptchaResponse::class.java)
        println("GOT RESPONSE: ${response}")
        return response!!
    }



}