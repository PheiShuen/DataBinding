package com.example.databinding

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val message:String = intent.getStringExtra(MainActivity.EXTRA_MESSAGE)
        textViewReceiver.text = String.format("%s : %s",getString(R.string.message),message)

        buttonDone.setOnClickListener {
            val intent = getIntent() //who called me?
            if(!editTextReply.text.isEmpty()){
                val reply = editTextReply.text.toString()
                intent.putExtra(MainActivity.EXTRA_REPLY,reply)
                setResult(Activity.RESULT_OK,intent)
            }
            else{
                setResult(Activity.RESULT_CANCELED,intent)
            }
            //Cloae activity
            finish()
        }
    }
}
