package my_rest_server.rest_server.entity

import com.fasterxml.jackson.annotation.JsonProperty


data class CaptchaResponse (
    var success : Boolean? = null,
    var challenge_ts : String? = null,
    var apk_package_name : String? = null,
    @JsonProperty("error-codes")
    var error_codes : List<String>? = null
)