package com.hugorafaelcosta.brewerybeesapp


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragmente_list_vertical.*
import kotlinx.android.synthetic.main.list_vertical.*

class MainActivity : AppCompatActivity() {

    private lateinit var breweryAdapter: BreweryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRecyclerView()
        addDatasource()
    }

    private fun addDatasource() {

        val dataSource = DataSource.createDataSet()
        this.breweryAdapter.setDataSet(dataSource)
    }

    private fun initRecyclerView() {

        this.breweryAdapter = BreweryAdapter()

        val horizontalLayoutManagaer =
            LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL, false)
        recyclerview_main.layoutManager = horizontalLayoutManagaer

        recyclerview_main.adapter = this.breweryAdapter
    }


}