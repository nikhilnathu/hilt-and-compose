package com.example.hiltandcompose.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.hiltandcompose.R
import com.example.hiltandcompose.databinding.FragmentMainBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainFragment : Fragment() {
    private val viewModel by viewModels<MainViewModel>()
    @Inject
    lateinit var string: String

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = DataBindingUtil.inflate<FragmentMainBinding>(
            inflater,
            R.layout.fragment_main,
            container,
            false
        )
        binding.lifecycleOwner = this

        viewModel.pokemon.observe(viewLifecycleOwner) {
            binding.message.text = it
        }

        binding.button.setOnClickListener {
            viewModel.getPokemon("wqioeuw")
        }

        return binding.root
    }
}
