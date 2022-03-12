package com.luc.loginsystem

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.DecelerateInterpolator
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.constraintlayout.widget.ConstraintSet
import androidx.core.view.doOnPreDraw
import androidx.core.view.forEach
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.findNavController
import androidx.transition.ChangeBounds
import androidx.transition.Transition
import androidx.transition.TransitionManager
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.material.transition.platform.MaterialSharedAxis
import com.luc.common.NetworkStatus
import com.luc.loginsystem.base.BaseFragment
import com.luc.loginsystem.databinding.FragmentLoginBinding
import com.luc.presentation.LoginViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginFragment : BaseFragment<FragmentLoginBinding>(FragmentLoginBinding::inflate) {

    private val loginViewModel: LoginViewModel by viewModel()

    private lateinit var googleSignInClient: GoogleSignInClient

    private var shouldAnimate: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()
        googleSignInClient = GoogleSignIn.getClient(requireActivity(), gso)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        exitTransition =
            MaterialSharedAxis(MaterialSharedAxis.X, /* forward= */ true).addTarget(binding.root)
        reenterTransition =
            MaterialSharedAxis(MaterialSharedAxis.X, /* forward= */ false).addTarget(binding.root)
        postponeEnterTransition()

        setFragmentResultListener("requestKey") { requestKey, bundle ->
            shouldAnimate = bundle.getBoolean("bundleKey")
        }

        view.doOnPreDraw { startPostponedEnterTransition() }
        binding.root.doOnPreDraw {
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

            constraintSet.applyTo(binding.root)
            if (shouldAnimate) {
                val transition: Transition = ChangeBounds()
                transition.interpolator = DecelerateInterpolator()
                transition.duration = 300
                binding.dataContainer.forEach { views ->
                    views.animate().alpha(1f).duration = 600
                }
                TransitionManager.beginDelayedTransition(binding.root, transition)
                binding.dataContainer.forEach { views ->
                    views.alpha = 0f
                }
            }

        }

        binding.login.setOnClickListener {
            if (binding.emailInput.text.toString()
                    .isEmpty() || binding.passwordInput.text.toString().isEmpty()
            ) return@setOnClickListener
            loginViewModel.signInWithEmailAndPassword(
                binding.emailInput.text.toString(),
                binding.passwordInput.toString()
            ).observe(viewLifecycleOwner) {
                when (it) {
                    is NetworkStatus.Success -> Toast.makeText(
                        requireContext(),
                        it.data.email,
                        Toast.LENGTH_LONG
                    ).show()
                    is NetworkStatus.Error -> Toast.makeText(
                        requireContext(),
                        it.message,
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        }

        binding.googleLogin.setOnClickListener {
            getContent.launch(googleSignInClient.signInIntent)
        }

        binding.signUp.setOnClickListener {
            findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToSignUpFragment())
        }

    }

    private val getContent =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK)
                onActivityResult(CODE_REQUEST, result)
        }

    private fun onActivityResult(requestCode: Int, result: ActivityResult) {
        val intent = result.data
        when (requestCode) {
            CODE_REQUEST -> {
                val task = GoogleSignIn.getSignedInAccountFromIntent(intent)
                try {
                    // Google Sign In was successful, authenticate with Firebase
                    val account = task.getResult(ApiException::class.java)
                    if (account != null) {
                        loginViewModel.signInWithGoogle(account.idToken!!)
                            .observe(viewLifecycleOwner) {
                                when (it) {
                                    is NetworkStatus.Success ->
                                        Toast.makeText(
                                            requireContext(),
                                            "Email:  ${it.data.email}, Provider: ${it.data.providerType.name}",
                                            Toast.LENGTH_LONG
                                        ).show()


                                    is NetworkStatus.Error -> Toast.makeText(
                                        requireContext(),
                                        it.message,
                                        Toast.LENGTH_LONG
                                    ).show()
                                }
                            }
                    }
                } catch (e: ApiException) {
                    // Google Sign In failed, update UI appropriately
                }
            }
        }
    }
}

const val CODE_REQUEST = 12