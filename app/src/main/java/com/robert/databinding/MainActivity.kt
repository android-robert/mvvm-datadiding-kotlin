package com.robert.databinding

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.robert.databinding.adapter.EmployeeDataAdapter
import com.robert.databinding.databinding.ActivityMainBinding
import com.robert.databinding.model.Employee
import java.util.*

class MainActivity : AppCompatActivity() {
    private var mainViewModel: MainViewModel? = null
    private var employeeDataAdapter: EmployeeDataAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activityMainBinding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        // bind RecyclerView
        val recyclerView = activityMainBinding.viewEmployees
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        mainViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        employeeDataAdapter = EmployeeDataAdapter()
        recyclerView.adapter = employeeDataAdapter
        getAllEmployee()
    }

    private fun getAllEmployee() {
        mainViewModel?.getAllEmployee()?.observe(this, Observer { employees -> employeeDataAdapter?.setEmployeeList(employees as ArrayList<Employee?>?) })
    }
}