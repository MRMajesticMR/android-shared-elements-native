package ru.arkasha.sharedelementsnative

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.core.view.doOnPreDraw
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.*
import ru.arkasha.sharedelementsnative.base.tuneVertical
import ru.arkasha.sharedelementsnative.data.UsersRepository
import ru.arkasha.sharedelementsnative.data.UsersRepositoryImpl

class FirstFragment : Fragment(R.layout.f_first) {

    private val job = SupervisorJob()
    private val ioScope by lazy { CoroutineScope(job + Dispatchers.IO) }

    private val usersRepository: UsersRepository = UsersRepositoryImpl()

    private val usersRecyclerViewAdapter by lazy {
        UsersRecyclerViewAdapter().apply {
            onClicked = { view, user ->
                showSecondFragment(view)
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        postponeEnterTransition()

        view.findViewById<RecyclerView>(R.id.tvUsers).tuneVertical(usersRecyclerViewAdapter)

        ioScope.launch {
            val users = usersRepository.getUsers()

            withContext(Dispatchers.Main) {
                usersRecyclerViewAdapter.setData(users)

                (view as? ViewGroup)?.doOnPreDraw {
                    startPostponedEnterTransition()
                }
            }
        }
    }

    private fun showSecondFragment(view: View) {
        activity?.supportFragmentManager?.commit {
            setReorderingAllowed(true)
            addSharedElement(view.findViewById(R.id.ivAvatar), "large_icon")
            replace(R.id.vgFragmentsContainer, SecondFragment())
            addToBackStack(null)
        }
    }


}