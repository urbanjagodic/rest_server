package my_rest_server.rest_server.entity

import com.fasterxml.jackson.annotation.JsonProperty

data class CaptchaRequest (
    @JsonProperty("secret")
    var secret : String?,
    @JsonProperty("response")
    var response : String?,
    var remoteip : String? = null
)