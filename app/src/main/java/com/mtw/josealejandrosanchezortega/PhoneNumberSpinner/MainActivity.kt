package com.mtw.josealejandrosanchezortega.PhoneNumberSpinner

import android.nfc.Tag
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.mtw.josealejandrosanchezortega.PhoneNumberSpinner.R.id.editText_main
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    // private val TAG : String = MainActivity::class.simpleName.toString()

    var mSpinnerLabel : String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // CONTENIDO DESARROLLADO:
        label_spinner.setOnItemSelectedListener(this)

        // SE CREA EL Adapter PARA EL SPINNER USANDO EL CONTENIDO EN arrya DEFINIDO EN EL RECURSO strings Y DEFINIÉNDOLO CON UN LAYOUT DEL ITEM DEL SPINNER COMO simple_spinner_item
        var adapter = ArrayAdapter.createFromResource(this, R.array.labels_array, android.R.layout.simple_spinner_item)

        // SE DEFINE UN LAYOUT PARA EL LISTADO DEL SPINNER
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        // SE ASOCIA EL ADAPTER PREVIAMENTE CREADO Y VINCULADO CON LOS DATOS, PERO AHORA CON EL WIDGET Spinner DEFINIDO EN EL ACTIVITY
        label_spinner.adapter = adapter

    }

    fun showText(view: View) {
        if (editText_main != null) {
            // SE CONCATENA EL VALOR DEL EditText MAS EL CONTENIDO DEL SPINNER
            val showString : String = editText_main.text.toString() + " - " + mSpinnerLabel

            // SE MUESTRA EL TEXTO EN EL DIALOGO TOAST
            Toast.makeText(this, showString, Toast.LENGTH_SHORT).show()

            // SE ACTUALIZA EL ESTASO DE LOS TEXTVIEW ABAJO
            text_phonelabel.text = showString
        }
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        mSpinnerLabel = parent?.getItemAtPosition(position).toString()
        showText(view!!)
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        // Log.d(TAG, getString(R.string.nothing_selected))
    }
}
