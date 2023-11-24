package com.example.challenge3binar.viewModel.fragmentHome

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.challenge3binar.network.model.product.ProductItemResponse
import com.example.challenge3binar.repository.RepositoryMenu
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations

class ViewModelFragmentHomeTest {

    @get:Rule
    var rule: InstantTaskExecutorRule = InstantTaskExecutorRule()

    // Pastikan objek RepositoryMenu diinisialisasi dengan benar
    private val repositoryMenu = RepositoryMenu()

    private lateinit var viewModel: ViewModelFragmentHome

    @Before
    fun setup() {
        // Mengganti MockitoAnnotations.openMocks(this) dengan inisialisasi langsung objek mock
        MockitoAnnotations.initMocks(this)
        viewModel = ViewModelFragmentHome(repositoryMenu)
    }

    @Test
    fun `test getListProduct`() {
        // viewModel sudah diinisialisasi dalam setup, maka bisa diakses di sini
        viewModel.getListProduct("testQuery")

        // melakukan asert atau verifikasi sesuai kebutuhan
    }



    private inline fun <reified T> mock(): T = org.mockito.Mockito.mock(T::class.java)
}
