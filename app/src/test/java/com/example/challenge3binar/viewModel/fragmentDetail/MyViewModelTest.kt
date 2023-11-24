package com.example.challenge3binar.viewModel.fragmentDetail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations
import org.mockito.ArgumentMatchers.anyInt

class MyViewModelTest {

    // Aturan ini memastikan bahwa pembaruan LiveData terjadi di thread yang sama
    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Mock
    lateinit var observer: Observer<Int>

    private lateinit var viewModel: MyViewModel

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        viewModel = MyViewModel()
    }

    @Test
    fun testIncrementCount() {
        // Menyambungkan observer ke LiveData
        viewModel.counter.observeForever(observer)

        // Melakukan operasi yang akan diuji
        viewModel.incrementCount()

        // Memverifikasi bahwa observer dipanggil dengan nilai yang diharapkan
        verify(observer).onChanged(1)

        // Membersihkan observer
        viewModel.counter.removeObserver(observer)
    }

    @Test
    fun testDecrementCount() {
        // Menyambungkan observer ke LiveData
        viewModel.counter.observeForever(observer)

        // Melakukan operasi yang akan diuji
        viewModel.decrementCount()

        // Memverifikasi bahwa observer dipanggil dengan nilai yang diharapkan
        verify(observer, times(1)).onChanged(0)

        // Membersihkan observer
        viewModel.counter.removeObserver(observer)
    }


}
