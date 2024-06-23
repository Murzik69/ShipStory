package com.example.myapplication.actfragview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.example.myapplication.R

class ButFragment1 : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view: View=inflater.inflate(R.layout.fragment_but1, container, false)
        val btn1: Button = view.findViewById(R.id.butList)
        val btn2: Button = view.findViewById(R.id.butInfo)
        btn1.setOnClickListener{findNavController().navigate(R.id.action1)}
        btn2.setOnClickListener{findNavController().navigate(R.id.action2)}
        return view
    }
}