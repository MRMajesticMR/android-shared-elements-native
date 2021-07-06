package ru.arkasha.sharedelementsnative

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit

class FirstFragment: Fragment(R.layout.f_first) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        view.findViewById<View>(R.id.bShow).setOnClickListener {
            showSecondFragment()
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