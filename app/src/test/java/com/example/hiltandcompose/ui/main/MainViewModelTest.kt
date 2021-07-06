package com.example.hiltandcompose.ui.main

import com.example.hiltandcompose.fake_repos.FakePokemonApi
import com.example.hiltandcompose.utils.InstantExecutorExtension
import com.example.hiltandcompose.utils.getOrAwaitValue
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.*
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExperimentalCoroutinesApi
@ExtendWith(InstantExecutorExtension::class)
class MainViewModelTest {

    private val testCoroutineDispatcher = TestCoroutineDispatcher()
    private val testCoroutineScope = TestCoroutineScope(testCoroutineDispatcher)

    lateinit var viewModel : MainViewModel

    @BeforeEach
    fun setup() {
        viewModel = MainViewModel(MainRepository(FakePokemonApi()))
        Dispatchers.setMain(testCoroutineDispatcher)
    }

    @AfterEach
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `test if pokemon live data is emitting name`() {
        viewModel.getPokemon("pikachu")
        assertThat(viewModel.pokemon.getOrAwaitValue()).isEqualTo("pikachu")
    }
}

