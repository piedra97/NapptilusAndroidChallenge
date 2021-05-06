package com.example.napptilusandroidchallenge.oompaloompalist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.napptilusandroidchallenge.databinding.OompaLoompaListFragmentBinding

class OompaLoompaListFragment : Fragment() {

    private lateinit var binding: OompaLoompaListFragmentBinding

    private lateinit var viewModel: OompaLoompaListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate view and obtain an instance of the binding class
        binding = OompaLoompaListFragmentBinding.inflate(layoutInflater)

        val adapter =
            OompaLoompaAdapter()
        binding.oompaloompaList.adapter = adapter

        viewModel = ViewModelProvider(this).get(OompaLoompaListViewModel::class.java)

        //TODO Add observable with live data in api results and inside observer add submitList(it)
        return binding.root

    }

}