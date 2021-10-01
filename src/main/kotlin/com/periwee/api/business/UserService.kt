package com.periwee.api.business

import com.periwee.api.business.models.User
import org.springframework.stereotype.Service

@Service
class UserService {
    private var users = mutableListOf<User>()

    private fun userExist(id: Int): Int {
        for ((index, user) in users.withIndex()){
            if(user.id == id) return index
        }
        return -1
    }

    fun getAllUsers(): MutableList<User> = users

    fun getUser(id:Int): User?{
        var user: User? = null
        for (u: User in users) {
            if(u.id == id) {
                user= u
            }
        }
        return user
    }

    fun addUser(user: User) : Boolean =  users.add(user)

    fun deleteUser(id: Int): Boolean {
        val user = getUser(id)
        if(user != null){
            return users.remove(user)
        }
        return false
    }
    fun getUserCount(): Int = users.count()

    fun reset(): Unit = users.clear()

    fun updateUser(user: User): User? {
       var userIndex = userExist(user.id)

        if(userIndex != -1){
            var result = users.set(userIndex, user)
            return users.get(userIndex)
        }
        return null

    }


}