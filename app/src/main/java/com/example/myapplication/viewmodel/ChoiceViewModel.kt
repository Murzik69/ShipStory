package com.example.myapplication.viewmodel

import androidx.lifecycle.ViewModel
import com.example.myapplication.model.ShipList

class ChoiceViewModel: ViewModel() {
    var name: Array<String> = ShipList.takeNames()
}