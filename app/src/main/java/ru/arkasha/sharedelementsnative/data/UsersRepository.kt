package ru.arkasha.sharedelementsnative.data

interface UsersRepository {

    suspend fun getUsers(): List<User>

}

class UsersRepositoryImpl : UsersRepository {

    private val users = (0..50).map {
        User(
            id = it.toString(),
            avatar = "https://www.patientpop.com/wp-content/uploads/national-doctors-day-1.jpg",
            name = "Имя пользователя $it"
        )
    }

    override suspend fun getUsers(): List<User> =
        users.toList()

}