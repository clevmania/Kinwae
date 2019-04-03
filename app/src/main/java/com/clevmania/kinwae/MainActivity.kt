package com.clevmania.kinwae

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.core.widget.NestedScrollView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_contact.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sv_account_opening.go(1,true)
        populateStateSpinner()
        populateCitySpinner()
        handleUpArrow()
        autoHideFloatingActionButton()
    }

    private fun handleUpArrow(){
        iv_back_nav.setOnClickListener { finish() }
    }

    private fun populateStateSpinner(){
        iv_state_spinner.setOnClickListener { sp_state.performClick() }
        val stateAdapter = ArrayAdapter
            .createFromResource(this,R.array.states, android.R.layout.simple_spinner_item)
        stateAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        sp_state.adapter = stateAdapter
    }

    private fun populateCitySpinner(){
        iv_city_spinner.setOnClickListener { sp_city.performClick() }
        val city = listOf("Ikeja","Maryland","Anthony","Ajah","Victoria Island","Ikoyi")
        val cityAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, city)
        cityAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        sp_city.adapter = cityAdapter
    }

    private fun autoHideFloatingActionButton(){
        nsv_contact.setOnScrollChangeListener(
            NestedScrollView.OnScrollChangeListener { _, _, scrollY, _, oldScrollY ->
                if (scrollY > oldScrollY) {
                    floatingActionButton.hide()
                } else {
                    floatingActionButton.show()
                }
        })
    }
}
