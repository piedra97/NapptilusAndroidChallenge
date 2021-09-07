package com.example.napptilusandroidchallenge.oompaloompadetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.napptilusandroidchallenge.databinding.OompaLoompaDetailFragmentBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class OompaLoompaDetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate view and obtain an instance of the binding class
        val binding = OompaLoompaDetailFragmentBinding.inflate(layoutInflater)

        val arguments = OompaLoompaDetailFragmentArgs.fromBundle(requireArguments())

        val oompaLoompaDetailViewModel: OompaLoompaDetailViewModel by viewModel { parametersOf(arguments.oompaLoompaKey)}

        binding.viewModel = oompaLoompaDetailViewModel

        binding.lifecycleOwner = this

        return binding.root
    }
}