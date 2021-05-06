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

    private lateinit var viewModel: OompaLoompaDetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate view and obtain an instance of the binding class
        binding = OompaLoompaDetailFragmentBinding.inflate(layoutInflater)

        //TODO: Add ViewModelFactory initialization
        viewModel = ViewModelProvider(this).get(OompaLoompaDetailViewModel::class.java)
        return binding.root
    }
}