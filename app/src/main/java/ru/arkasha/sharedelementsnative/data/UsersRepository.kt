package ru.arkasha.sharedelementsnative.data

import kotlinx.coroutines.delay

interface UsersRepository {

    suspend fun getUsers(): List<User>

}

class UsersRepositoryImpl : UsersRepository {

    override suspend fun getUsers(): List<User> {
        delay(500)

        return (0..50).map {
            User(
                id = it.toString(),
                avatar = "https://www.patientpop.com/wp-content/uploads/national-doctors-day-1.jpg",
                name = "Имя пользователя $it"
            )
        }
    }

}