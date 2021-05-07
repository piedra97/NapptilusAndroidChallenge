package com.example.napptilusandroidchallenge.oompaloompadetail

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.napptilusandroidchallenge.databinding.OompaLoompaDetailFragmentBinding

class OompaLoompaDetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate view and obtain an instance of the binding class
        val binding = OompaLoompaDetailFragmentBinding.inflate(layoutInflater)

        val arguments = OompaLoompaDetailFragmentArgs.fromBundle(requireArguments())

        val oompaLoompaDetailViewModelFactory = OompaLoompaDetailViewModelFactory(arguments.oompaLoompaKey)
        val oompaLoompaDetailViewModel = ViewModelProvider(this, oompaLoompaDetailViewModelFactory).get(OompaLoompaDetailViewModel::class.java)

        binding.viewModel = oompaLoompaDetailViewModel

        binding.lifecycleOwner = this

        return binding.root
    }
}