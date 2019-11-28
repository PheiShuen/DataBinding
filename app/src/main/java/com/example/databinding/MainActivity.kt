package com.example.databinding

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Create an event handler for buttonSend
        buttonSend.setOnClickListener {
            sendMesaage()
        }
    }

    private fun sendMesaage(){
        //Create an explicit intent for the second activity
        val intent = Intent(this, SecondActivity::class.java)

        //Prepare extra
        val message = editTextMessage.text.toString()
        intent.putExtra(EXTRA_MESSAGE, message)
        //startActivity(intent) //start activity with no return value
        //start an activity with return value(s)/ result(s)
        startActivityForResult(intent, REQUEST_REPLY)
    }

    override fun onActivityResult(requestCode: Int,
                                  resultCode: Int,
                                  data: Intent?) {
        if(requestCode== REQUEST_REPLY){
            if(resultCode == Activity.RESULT_OK){
                val reply = data?.getStringExtra(MainActivity.EXTRA_REPLY)
                textViewReply.text = String.format("%s : %s",
                    getString(R.string.reply),reply)
            }
            else{
                textViewReply.text = String.format("%s : %s",
                    getString(R.string.reply),"No reply")
            }
        }
        super.onActivityResult(requestCode, resultCode, data)
    }

    companion object{
        val  EXTRA_MESSAGE = "com.example.databinding.MESSAGE"
        val  EXTRA_REPLY = "com.example.databinding.REPLY"
        val  REQUEST_REPLY = 1 //any number of you, as long it is unit

    }
}//End of class
