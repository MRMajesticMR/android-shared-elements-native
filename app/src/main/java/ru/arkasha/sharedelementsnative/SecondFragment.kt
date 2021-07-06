package ru.arkasha.sharedelementsnative

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.transition.TransitionInflater

class SecondFragment : Fragment(R.layout.f_second) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        sharedElementEnterTransition = TransitionInflater
            .from(requireContext())
            .inflateTransition(R.transition.image_transition)

        postponeEnterTransition()

        startPostponedEnterTransition()
    }


}