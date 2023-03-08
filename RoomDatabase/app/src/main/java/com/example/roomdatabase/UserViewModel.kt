package com.example.roomdatabase

import androidx.lifecycle.*
import kotlinx.coroutines.launch

class UserViewModel(private val userRepository : UserRepository) : ViewModel()
{
    val allUserData : LiveData<List<User>> = userRepository.allUserData

    fun addUser(inputUser : User)
    {
        viewModelScope.launch {
            userRepository.insertUser(inputUser)
        }
    }

    fun deleteAllUsers()
    {
        viewModelScope.launch {
            userRepository.deleteAllUsers()
        }
    }
}

//  Handles the creation of UserViewModel instances
class UserViewModelFactory(private val userRepository: UserRepository) : ViewModelProvider.Factory
{
    // Overrides create method and checks if requested ViewModel is the UserViewModel
    override fun <T : ViewModel> create(modelClass : Class<T>) : T
    {
        // checks if requested ViewModel is the UserViewModel
        if(modelClass.isAssignableFrom(UserViewModel::class.java))
        {
            return UserViewModel(userRepository) as T
        }
        // else throw exception
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}