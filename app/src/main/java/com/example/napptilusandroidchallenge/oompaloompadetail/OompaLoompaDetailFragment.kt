package com.example.napptilusandroidchallenge.oompaloompadetail

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.napptilusandroidchallenge.databinding.OompaLoompaDetailFragmentBinding

class OompaLoompaDetailFragment : Fragment() {

    private lateinit var binding: OompaLoompaDetailFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate view and obtain an instance of the binding class
        binding = OompaLoompaDetailFragmentBinding.inflate(layoutInflater)

        val arguments = OompaLoompaDetailFragmentArgs.fromBundle(requireArguments())

        val oompaLoompaDetailViewModelFactory = OompaLoompaDetailViewModelFactory(arguments.oompaLoompaKey)
        val oompaLoompaDetailViewModel = ViewModelProvider(this, oompaLoompaDetailViewModelFactory).get(OompaLoompaDetailViewModel::class.java)

        return binding.root
    }
}