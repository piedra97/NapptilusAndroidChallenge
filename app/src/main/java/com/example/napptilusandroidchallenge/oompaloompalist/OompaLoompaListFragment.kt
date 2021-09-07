package com.example.napptilusandroidchallenge.oompaloompalist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.napptilusandroidchallenge.databinding.OompaLoompaListFragmentBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class OompaLoompaListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate view and obtain an instance of the binding class
        val binding = OompaLoompaListFragmentBinding.inflate(layoutInflater)

        val oompaLoompaListViewModel: OompaLoompaListViewModel by viewModel()

        val adapter = OompaLoompaAdapter(
            onOompaLoompaClickedListener = { oompaLoompa ->
                oompaLoompaListViewModel.onOompaLoompaClicked(oompaLoompa.id)
            })

        binding.apply {
            viewModel = oompaLoompaListViewModel
            oompaloompaList.adapter = adapter
        }

        binding.lifecycleOwner = this

        oompaLoompaListViewModel.response.observe(
            viewLifecycleOwner,
            { oompaLoompas -> adapter.setItems(oompaLoompas) })

        oompaLoompaListViewModel.navigateOompaLoompaDetail.observe(
            viewLifecycleOwner,
            Observer { oompaloompa ->
                oompaloompa?.let {
                    this.findNavController().navigate(
                        OompaLoompaListFragmentDirections.actionOompaLoompaListFragmentToOompaLoompaDetailFragment(
                            oompaloompa
                        )
                    )
                    oompaLoompaListViewModel.onOompaLoompaDetailNavigated()
                }
            })

        return binding.root

    }

}