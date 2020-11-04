package com.robert.databinding.model

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.google.gson.annotations.SerializedName
import com.robert.databinding.R

class Employee {
    @SerializedName("avatar")
    private var avatar: String? = null

    @SerializedName("email")
    private var email: String? = null

    @SerializedName("first_name")
    private var firstName: String? = null

    @SerializedName("id")
    private var id: Long? = null

    @SerializedName("last_name")
    private var lastName: String? = null
    fun getAvatar(): String? {
        return avatar
    }

    fun setAvatar(avatar: String?) {
        this.avatar = avatar
    }

    fun getEmail(): String? {
        return email
    }

    fun setEmail(email: String?) {
        this.email = email
    }

    fun getFirstName(): String? {
        return firstName
    }

    fun setFirstName(firstName: String?) {
        this.firstName = firstName
    }

    fun getId(): Long? {
        return id
    }

    fun setId(id: Long?) {
        this.id = id
    }

    fun getLastName(): String? {
        return lastName
    }

    fun setLastName(lastName: String?) {
        this.lastName = lastName
    }

    companion object {
        // important code for loading image here
        @JvmStatic
        @BindingAdapter("avatar")
        fun loadImage(imageView: ImageView?, imageURL: String?) {
            Glide.with(imageView!!.context)
                    .setDefaultRequestOptions(RequestOptions().circleCrop())
                    .load(imageURL)
                    .placeholder(R.drawable.loading)
                    .into(imageView)
        }
    }
}