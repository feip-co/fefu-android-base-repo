package com.example.app

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.app.databinding.FragmentProfileFragmentBinding


class Profile_fragment : Fragment(R.layout.fragment_profile_fragment) {

    private var _binding: FragmentProfileFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        const val tag = "profile_fragment"

        fun newInstance() : Profile_fragment {
            val fragment = Profile_fragment()
            fragment.arguments = Bundle()
            return fragment
        }
    }
}
