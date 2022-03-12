package com.luc.loginsystem

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.AnticipateOvershootInterpolator
import android.view.animation.DecelerateInterpolator
import android.view.animation.LinearInterpolator
import androidx.constraintlayout.widget.ConstraintSet
import androidx.core.view.forEach
import androidx.transition.ChangeBounds
import androidx.transition.Transition
import androidx.transition.TransitionManager
import com.luc.loginsystem.base.BaseFragment
import com.luc.loginsystem.databinding.FragmentLoginBinding


class LoginFragment : BaseFragment<FragmentLoginBinding>(FragmentLoginBinding::inflate) {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return super.onCreateView(inflater, container, savedInstanceState)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.dataContainer.forEach { views ->
            views.alpha = 0f
        }

        val constraintSet = ConstraintSet()
        constraintSet.clone(binding.root)
        constraintSet.clear(binding.logo.id, ConstraintSet.BOTTOM)
        constraintSet.clear(binding.dataContainer.id, ConstraintSet.TOP)
        constraintSet.connect(
            binding.dataContainer.id,
            ConstraintSet.BOTTOM,
            ConstraintSet.PARENT_ID,
            ConstraintSet.BOTTOM
        )
        val transition: Transition = ChangeBounds()
        transition.interpolator = DecelerateInterpolator()
        transition.duration = 300
        binding.dataContainer.forEach { views ->
            views.animate().alpha(1f).duration = 600
        }
        TransitionManager.beginDelayedTransition(binding.root, transition)
        constraintSet.applyTo(binding.root)
    }

}