package com.example.napptilusandroidchallenge.oompaloompalist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.napptilusandroidchallenge.databinding.OompaLoompaListFragmentBinding

class OompaLoompaListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate view and obtain an instance of the binding class
        val binding = OompaLoompaListFragmentBinding.inflate(layoutInflater)

        val oompaLoompaListViewModel = ViewModelProvider(this).get(OompaLoompaListViewModel::class.java)

        val adapter = OompaLoompaAdapter(OompaLoompaListener { oompaLoompaId ->
            oompaLoompaListViewModel.onOompaLoompaClicked(oompaLoompaId)
        })

        binding.viewModel = oompaLoompaListViewModel

        binding.oompaloompaList.adapter = adapter

        binding.lifecycleOwner = this

        oompaLoompaListViewModel.navigateOompaLoompaDetail.observe(viewLifecycleOwner, Observer { oompaloompa ->
            oompaloompa?.let {
                this.findNavController().navigate(
                        OompaLoompaListFragmentDirections.actionOompaLoompaListFragmentToOompaLoompaDetailFragment(oompaloompa))
                oompaLoompaListViewModel.onOompaLoompaDetailNavigated()
            }
        })

        return binding.root

    }

}