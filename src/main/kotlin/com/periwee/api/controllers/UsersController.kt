package com.periwee.api.controllers

import com.periwee.api.business.UserService
import com.periwee.api.business.models.User
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/users")
class UsersController(var userService: UserService) {

    @GetMapping
    fun getAllUsers(): MutableList<User> = userService.getAllUsers()

    @GetMapping("/{id}")
    fun getUserById(@PathVariable id: Int): User? = userService.getUser(id)

    @DeleteMapping("/{id}")
    fun deleteUserById(@PathVariable id: Int): Boolean = userService.deleteUser(id)

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun addUser(@RequestBody user: User) = userService.addUser(user)

    @PutMapping
    fun updateUser(@RequestBody user: User) : User? = userService.updateUser(user)

}