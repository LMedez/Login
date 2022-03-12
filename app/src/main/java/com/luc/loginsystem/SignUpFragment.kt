package com.luc.loginsystem

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.FragmentManager.POP_BACK_STACK_INCLUSIVE
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import com.google.android.material.transition.platform.MaterialSharedAxis
import com.luc.loginsystem.base.BaseFragment
import com.luc.loginsystem.databinding.FragmentSignUpBinding


class SignUpFragment : BaseFragment<FragmentSignUpBinding>(FragmentSignUpBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        enterTransition =
            MaterialSharedAxis(MaterialSharedAxis.X, /* forward= */ true).addTarget(binding.root)
        returnTransition =
            MaterialSharedAxis(MaterialSharedAxis.X, /* forward= */ false).addTarget(binding.root)

        exitTransition =
            MaterialSharedAxis(MaterialSharedAxis.X, /* forward= */ true).addTarget(binding.root)
        reenterTransition =
            MaterialSharedAxis(MaterialSharedAxis.X, /* forward= */ false).addTarget(binding.root)
        binding.popBack.setOnClickListener {
            setFragmentResult("requestKey", bundleOf("bundleKey" to false))
            findNavController().popBackStack()
        }
    }

}