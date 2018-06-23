package com.mtw.josealejandrosanchezortega.PhoneNumberSpinner

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.mtw.josealejandrosanchezortega.PhoneNumberSpinner.R.id.editText_main
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        label_spinner!!.setOnItemSelectedListener(this)

        var list_of_items = arrayOf("Item 1", "Item 2", "Item 3")
        val aa = ArrayAdapter(this, label_spinner, list_of_items)
        aa.setDropDownViewResource(label_spinner)
        label_spinner.adapter(aa)
    }

    fun showText(view: View) {
        if (editText_main != null)
            Toast.makeText(this, editText_main.text.toString(), Toast.LENGTH_SHORT).show()
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.

    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
