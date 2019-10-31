package com.example.lesson_07_android_recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lesson_07_android_recyclerview.data.PlaceListAdapter
import com.example.lesson_07_android_recyclerview.model.Place
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var adapter:PlaceListAdapter?=null
    private var countryList:ArrayList<Place>?=null
    private var layoutManager:RecyclerView.LayoutManager?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        countryList=ArrayList<Place>()
        layoutManager=LinearLayoutManager(this)
        adapter=PlaceListAdapter(countryList!!,this)

        myRecyclerView.layoutManager=layoutManager
        myRecyclerView.adapter=adapter

        var countryNameList:Array<String> = arrayOf("Canada","USA")
        var citiesNameList:Array<String> = arrayOf("Ottawa","Washington, D.C.")

        for(i in 0..(countryNameList.size - 1)){
            var place = Place()
            place.CountryName = countryNameList[i]
            place.CityName=citiesNameList[i]
            countryList?.add(place);
        }
        adapter!!.notifyDataSetChanged()
    }


}
