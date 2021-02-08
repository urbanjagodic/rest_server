package my_rest_server.rest_server.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import my_rest_server.rest_server.entity.User
import my_rest_server.rest_server.respository.UserRepository

@Service
class UserService {

    @Autowired
    lateinit var userRepository : UserRepository


    fun getAllUsers() : List<User> = userRepository.findAll()


    fun addUser() {

        var newUser = User(null, "asfsdf", "asfdf", "asfdaf")

        userRepository.saveAndFlush(newUser)
    }

}