package com.example.napptilusandroidchallenge.oompaloompalist

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.napptilusandroidchallenge.getOrAwaitValue
import junit.framework.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class OompaLoompaListViewModelTest {
    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @Test
    fun onOompaLoompaClicked_setNavigatedToOompaLoompaDetailId() {

        // Given a fresh OompaLoompaListViewModel
        val oompaLoompaListViewModel = OompaLoompaListViewModel(ApplicationProvider.getApplicationContext())

        //OompaLoompa list element with id 1 clicked
        oompaLoompaListViewModel.onOompaLoompaClicked(1)

        //Then the navigateToOompaLoompaDetail Id changes
        val value = oompaLoompaListViewModel.navigateOompaLoompaDetail.getOrAwaitValue()

        // Check if oompa loompa id is equals to the one clicked
        assertEquals(value, 1)
    }
}