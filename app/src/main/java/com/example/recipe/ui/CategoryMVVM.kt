package com.example.recipe.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.recipe.data.CategoryResponse
import com.example.recipe.data.Category
import com.example.recipe.data.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CategoryMVVM : ViewModel() {
    private var categories: MutableLiveData<List<Category>> = MutableLiveData<List<Category>>()

    init {
        getCategories()
    }

    private fun getCategories(){
        RetrofitInstance.foodApi.getCategories().enqueue(object : Callback<CategoryResponse>{
            override fun onResponse(call: Call<CategoryResponse>, response: Response<CategoryResponse>) {
                categories.value = response.body()!!.categories
            }

            override fun onFailure(call: Call<CategoryResponse>, t: Throwable) {
                Log.d(TAG,t.message.toString())
            }

        })
    }

    fun observeCategories():LiveData<List<Category>>{
        return categories
    }
}