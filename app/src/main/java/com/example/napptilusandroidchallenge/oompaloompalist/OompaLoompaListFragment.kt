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

    private lateinit var binding: OompaLoompaListFragmentBinding

    private lateinit var oompaLoompaListViewModel: OompaLoompaListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate view and obtain an instance of the binding class
        binding = OompaLoompaListFragmentBinding.inflate(layoutInflater)

        oompaLoompaListViewModel = ViewModelProvider(this).get(OompaLoompaListViewModel::class.java)

        val adapter = OompaLoompaAdapter(OompaLoompaListener { oompaLoompaId ->
            oompaLoompaListViewModel.onOompaLoompaClicked(oompaLoompaId)
        })

        oompaLoompaListViewModel.navigateOompaLoompaDetail.observe(viewLifecycleOwner, Observer { oompaloompa ->
            oompaloompa?.let {
                this.findNavController().navigate(
                    OompaLoompaListFragmentDirections.actionOompaLoompaListFragmentToOompaLoompaDetailFragment(oompaloompa))
                oompaLoompaListViewModel.onOompaLoompaDetailNavigated()
            }
        })
        binding.oompaloompaList.adapter = adapter

        //TODO Add observable with live data in api results and inside observer add submitList(it)
        return binding.root

    }

}