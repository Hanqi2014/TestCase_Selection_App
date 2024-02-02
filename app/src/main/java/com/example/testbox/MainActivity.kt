package com.example.testbox

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Array of test cases
        var TestList = ArrayList<String>()
        val database = mutableListOf("1","2","3","4","5","6","7","8","9","10")
        for(list in database){
            TestList.add(list)
        }

        //Create adapter
        val adapter = ArrayAdapter(this,android.R.layout.simple_list_item_activated_1,TestList)
        val listview = findViewById<ListView>(R.id.testlist)
        listview.adapter = adapter

        //Click reaction
        listview.setOnItemClickListener { parent, view, position, id ->
            Toast.makeText(this,adapter.getItem(position),Toast.LENGTH_SHORT).show()
        }

        //Jump to test configuration interface after button Configure clicked
        val buttonConfigure = findViewById<Button>(R.id.configure_button)
        buttonConfigure.setOnClickListener {
            val intent = Intent(this,TestcaseConfiguration::class.java)
            startActivity(intent)
        }

        //Jump to activity InitialiseTest after button Confirm clicked
        val buttonConfirm = findViewById<Button>(R.id.confirm_button)
        buttonConfirm.setOnClickListener {
            val intent = Intent(this,SelectionConfirm::class.java)
            startActivity(intent)
        }

    }

}