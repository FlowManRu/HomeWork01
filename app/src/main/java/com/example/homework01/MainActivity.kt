package com.example.homework01

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun buttonOne (view: View) {
        val button1 = Intent(this, BadBoys::class.java)
        startActivity(button1)
        textView.setBackgroundColor(Color.RED)
        textView2.setBackgroundColor(Color.WHITE)
        textView3.setBackgroundColor(Color.WHITE)
        textView4.setBackgroundColor(Color.WHITE)
    }

    fun buttonTwo (view: View) {
        val button2 = Intent(this, TheMatrix::class.java)
        startActivity(button2)
        textView2.setBackgroundColor(Color.RED)
        textView.setBackgroundColor(Color.WHITE)
        textView3.setBackgroundColor(Color.WHITE)
        textView4.setBackgroundColor(Color.WHITE)
    }

    fun buttonThree(view: View) {
        val button3 = Intent (this, TheNetwork::class.java)
        startActivity(button3)
        textView3.setBackgroundColor(Color.RED)
        textView.setBackgroundColor(Color.WHITE)
        textView2.setBackgroundColor(Color.WHITE)
        textView4.setBackgroundColor(Color.WHITE)
    }

    fun buttonFour (view: View) {
        val button4 = Intent (this, TheWarcraft::class.java)
        textView.setBackgroundColor(Color.WHITE)
        textView4.setBackgroundColor(Color.RED)
        textView2.setBackgroundColor(Color.WHITE)
        textView3.setBackgroundColor(Color.WHITE)
        startActivity(button4)
    }

    fun clickImplicit(view: View) {
        val textMessage = "Our message"
        val sendIntent = Intent()
        sendIntent.action = Intent.ACTION_SEND
        sendIntent.putExtra(Intent.EXTRA_TEXT, textMessage)
        sendIntent.type = "text/plain"
        val title = resources.getString(R.string.chooser_title)
        // Создаем Intent для отображения диалога выбора.
        val chooser = Intent.createChooser(sendIntent, title)
        // Проверяем, что intent может быть успешно обработан
        sendIntent.resolveActivity(packageManager)?.let {
            startActivity(chooser)
        }
    }


}



