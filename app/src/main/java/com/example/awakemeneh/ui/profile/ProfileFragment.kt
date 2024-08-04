package com.example.awakemeneh.ui.profile

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.awakemeneh.databinding.FragmentProfileBinding
import com.example.awakemeneh.ui.autentikasi.PreferenceManager
import com.example.awakemeneh.ui.autentikasi.SignInActivity
import com.google.firebase.auth.FirebaseAuth

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.logoutprofile.setOnClickListener {
            signOut()
        }

        binding.logouticon.setOnClickListener {
            signOut()
        }
    }

    private fun signOut() {
        FirebaseAuth.getInstance().signOut()
        PreferenceManager.logout(requireContext()) // Ensure this line is correct
        val intent = Intent(activity, SignInActivity::class.java)
        startActivity(intent)
        activity?.finish()
        Toast.makeText(activity, "Signed out successfully", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
