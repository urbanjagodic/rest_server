package my_rest_server.rest_server.respository

import org.springframework.data.jpa.repository.JpaRepository
import my_rest_server.rest_server.entity.User

interface UserRepository : JpaRepository<User, Int> {
    
}