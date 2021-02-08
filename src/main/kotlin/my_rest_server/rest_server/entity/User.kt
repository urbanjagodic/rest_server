package my_rest_server.rest_server.entity

import javax.persistence.*

@Entity
@Table(name = "User")
data class User (

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    val id: Int? = 0,

    @Column(name = "NAME")
    val name: String,

    @Column(name = "SURNAME")
    val surname: String,

    @Column(name = "EMAIL")
    val email: String
)