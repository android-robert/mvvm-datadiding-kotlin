package com.robert.databinding.network

import com.robert.databinding.model.EmployeeDBResponse
import retrofit2.Call
import retrofit2.http.GET

interface EmployeeDataService {
    @GET("users/?per_page=12&amp;page=1")
    open fun getEmployees(): Call<EmployeeDBResponse?>?
}