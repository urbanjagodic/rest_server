package my_rest_server.rest_server.controller

import my_rest_server.rest_server.entity.CaptchaRequest
import my_rest_server.rest_server.entity.MyData
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.ModelAndView
import my_rest_server.rest_server.entity.User
import my_rest_server.rest_server.service.UserService

@RestController
@RequestMapping("/api/user")
class UserController {

    @Autowired
    lateinit var userService: UserService


    @GetMapping("/all")
    fun getAllUsers() : List<User> = userService.getAllUsers()

    @GetMapping("/test")
    fun test() : ModelAndView {
        return ModelAndView("test")
    }

    @PostMapping("/test")
    fun testPost(@RequestBody data : MyData) : ResponseEntity<Any?> {
        println(data);
        userService.addUser()
        return ResponseEntity.ok(true)
    }

    @PostMapping("/verify_captcha")
    fun verifyCaptcha(@RequestBody token : CaptchaRequest) : ResponseEntity<Any?> {
        println("Got verify_captcha request")
        return ResponseEntity.ok(true)
    }


}