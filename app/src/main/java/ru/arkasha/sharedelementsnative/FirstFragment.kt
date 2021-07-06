package ru.arkasha.sharedelementsnative

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import kotlinx.coroutines.*
import ru.arkasha.sharedelementsnative.data.UsersRepository
import ru.arkasha.sharedelementsnative.data.UsersRepositoryImpl
import kotlin.coroutines.CoroutineContext

class FirstFragment : Fragment(R.layout.f_first) {

    private val job = SupervisorJob()
    private val ioScope by lazy { CoroutineScope(job + Dispatchers.IO) }

    private val usersRepository: UsersRepository = UsersRepositoryImpl()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        view.findViewById<View>(R.id.bShow).setOnClickListener {
            showSecondFragment()
        }

        ioScope.launch {
            val users = usersRepository.getUsers()

            withContext(Dispatchers.Main) {

            }
        }
    }

    private fun showSecondFragment() {
        val imageView = view?.findViewById<View>(R.id.ivIcon) ?: return

        activity?.supportFragmentManager?.commit {
            setReorderingAllowed(true)
            addSharedElement(imageView, "large_icon")
            replace(R.id.vgFragmentsContainer, SecondFragment())
            addToBackStack(null)
        }
    }


}