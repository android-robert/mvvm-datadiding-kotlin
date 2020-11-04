package com.robert.databinding.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.robert.databinding.R
import com.robert.databinding.adapter.EmployeeDataAdapter.EmployeeViewHolder
import com.robert.databinding.databinding.EmployeeListItemBinding
import com.robert.databinding.model.Employee
import java.util.*

class EmployeeDataAdapter : RecyclerView.Adapter<EmployeeViewHolder?>() {
    private var employees: ArrayList<Employee?>? = null

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): EmployeeViewHolder {
        val employeeListItemBinding: EmployeeListItemBinding = DataBindingUtil.inflate(LayoutInflater.from(viewGroup.context), R.layout.employee_list_item, viewGroup, false)
        return EmployeeViewHolder(employeeListItemBinding)
    }

    override fun onBindViewHolder(employeeViewHolder: EmployeeViewHolder, i: Int) {
        val currentStudent = employees?.get(i)
        employeeViewHolder.employeeListItemBinding?.employee = currentStudent
    }

    override fun getItemCount(): Int {
        return employees?.size ?: 0
    }

    fun setEmployeeList(employees: ArrayList<Employee?>?) {
        this.employees = employees
        notifyDataSetChanged()
    }

    class EmployeeViewHolder(employeesListItemBinding: EmployeeListItemBinding) : ViewHolder(employeesListItemBinding.root) {
        val employeeListItemBinding: EmployeeListItemBinding?

        init {
            employeeListItemBinding = employeesListItemBinding
        }
    }
}