package com.example.myapplication.actfragview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentBut2Binding
import com.example.myapplication.viewmodel.ChoiceViewModel

class ButFragment2 : Fragment() {
    private lateinit var choiceVM: ChoiceViewModel
    private lateinit var binding: FragmentBut2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        choiceVM = ChoiceViewModel()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_but2, container, false)
        val view: View=binding.root
        binding.choiceVM = choiceVM
        val btn1: Button = view.findViewById(R.id.but1)
        val btn2: Button = view.findViewById(R.id.but2)
        val btn3: Button = view.findViewById(R.id.but3)
        val btn4: Button = view.findViewById(R.id.but4)
        btn1.setOnClickListener{findNavController().navigate(R.id.action3, bundleOf("argum" to "0"))}
        btn2.setOnClickListener{findNavController().navigate(R.id.action3, bundleOf("argum" to "1"))}
        btn3.setOnClickListener{findNavController().navigate(R.id.action3, bundleOf("argum" to "2"))}
        btn4.setOnClickListener{findNavController().navigate(R.id.action3, bundleOf("argum" to "3"))}
        return view
    }
}