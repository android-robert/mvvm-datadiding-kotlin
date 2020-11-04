package com.robert.databinding

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.robert.databinding.model.Employee
import com.robert.databinding.model.EmployeeRepository

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val employeeRepository: EmployeeRepository = EmployeeRepository()

    fun getAllEmployee(): LiveData<MutableList<Employee?>?>? {
        return employeeRepository.getMutableLiveData()
    }

    init {

    }
}