package com.robert.databinding.model

import androidx.lifecycle.MutableLiveData
import com.robert.databinding.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class EmployeeRepository {
    private var employees: ArrayList<Employee?>? = ArrayList()
    private val mutableLiveData: MutableLiveData<MutableList<Employee?>?>? = MutableLiveData()

    fun getMutableLiveData(): MutableLiveData<MutableList<Employee?>?>? {

        val userDataService = RetrofitClient.getService()
        userDataService?.getEmployees()?.enqueue(object : Callback<EmployeeDBResponse?> {

            override fun onResponse(call: Call<EmployeeDBResponse?>?, response: Response<EmployeeDBResponse?>?) {
                val employeeDBResponse = response?.body()
                if (employeeDBResponse?.employee != null) {
                    employees = employeeDBResponse.employee as ArrayList<Employee?>
                    mutableLiveData?.value = employees
                }
            }

            override fun onFailure(call: Call<EmployeeDBResponse?>?, t: Throwable?) {}
        })
        return mutableLiveData
    }

    companion object {
        private val TAG: String? = "EmployeeRepository"
    }
}