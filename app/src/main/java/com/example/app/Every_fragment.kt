package com.example.app

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.app.databinding.FragmentEveryFragmentBinding

class Every_fragment : Fragment(R.layout.fragment_every_fragment) {
    private var _binding: FragmentEveryFragmentBinding? = null
    private val binding get() =_binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEveryFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        const val tag = "every_activity_fragment"

        fun newInstance():  Every_fragment {
            val fragment = Every_fragment()
            fragment.arguments = Bundle()
            return fragment
        }
    }
}