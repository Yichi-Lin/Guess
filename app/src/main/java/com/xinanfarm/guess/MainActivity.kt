package com.xinanfarm.guess

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val secretNumber = SecretNumber()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("MainActivity", "secret number: " + secretNumber.secret)
    }

    fun check(view : View) {
        val number = txt_number.text.toString().toInt();
        Log.d("MainActivity", "check: $number")
        val diff = secretNumber.validate(number)
        var message = ""
        if ( diff > 0) {
            message = "Smaller"
        } else if ( diff < 0) {
            message = "Bigger"
        } else {
            message = "Yes, you got it"
        }
        //Log.d("MainActivity", message)
        //Toast.makeText(this, message, Toast.LENGTH_LONG).show()
        AlertDialog.Builder(this).setTitle("Message").setMessage(message).setPositiveButton("OK", null).show()
    }
}