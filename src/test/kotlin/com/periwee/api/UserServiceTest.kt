package com.periwee.api

import com.periwee.api.business.UserService
import com.periwee.api.business.models.User
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import javax.validation.constraints.AssertTrue

class userServiceTest {

    private var userService = UserService()

    @BeforeEach
    fun before(){
        userService = UserService()
    }

    @AfterEach
    fun after(){
        userService.reset()
    }

    @Test
    fun `should return all users`(){
        var users = userService.getAllUsers()
        Assertions.assertEquals(users.count(),0)
        userService.addUser(User(1,"Periwee",20))
        Assertions.assertEquals(users.count(),1)
    }

    @Test
    fun `should return a user if exist within the array`(){
        userService.addUser(User(1,"Periwee",20))
        var user = userService.getUser(1)
        Assertions.assertNotNull(user)
    }

    @Test
    fun `should return null if user doesn't exist within the array`(){
        println("ghgj ${userService.getUserCount()}")
        var user = userService.getUser(-1)
        Assertions.assertNull(user)
    }

    @Test
    fun `should add a user`(){
        Assertions.assertEquals(userService.getUserCount(),0)
        var result = userService.addUser(User(1,"Periwee",20))
        Assertions.assertTrue(result)
        Assertions.assertEquals(userService.getUserCount(),1)
    }

    @Test
    fun `should delete a user`(){
        userService.addUser(User(1,"Periwee",20))
        Assertions.assertEquals(userService.getUserCount(),1)
        var result = userService.deleteUser(-1)
        Assertions.assertFalse(result)
        result = userService.deleteUser(1)
        Assertions.assertTrue(result)
    }

    @Test
    fun `should update a user`(){
        var user = User(1,"Periwee",20)
        var user2 = User (2,"Carlos",19)
        var result = userService.addUser(user)


        Assertions.assertTrue(result)
        Assertions.assertEquals(user.id,1)
        Assertions.assertEquals(user.name,"Periwee")
        Assertions.assertEquals(user.age,20)


        user.name = "Esperanza"
        user.age = 21

        user2.name = "Garrita"
        user2.age = 20

        var result1 = userService.updateUser(user)
        var result2 = userService.updateUser(user2)

        Assertions.assertEquals(result1?.id,1)
        Assertions.assertEquals(result1?.name,"Esperanza")
        Assertions.assertEquals(result1?.age,21)

        Assertions.assertNull(result2)
    }



}