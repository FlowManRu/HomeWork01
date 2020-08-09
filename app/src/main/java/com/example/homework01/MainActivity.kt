package com.example.homework01

import android.app.AlertDialog
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_news.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRecycler()
        initRecyclerFan()
    }

    private val items = mutableListOf(
        NewsItem("News Item 1", "subtitle 1"),
        NewsItem("News Item 2", "subtitle 2"),
        NewsItem("News Item 3", "subtitle 3")
    )

    private val itemsFilm = mutableListOf(
        FilmItem("Film Item 1", "subtitle 1"),
        FilmItem("Film Item 2", "subtitle 2"),
        FilmItem("Film Item 3", "subtitle 3")
    )

    private fun initRecyclerFan() {
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerFan)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = FilmAdapter(itemsFilm)
    }

    //Главное окно
    private fun initRecycler() {
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        val recyclerView = findViewById<RecyclerView>(R.id.recycler)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = NewsAdapter(items)
    }

    //Список избранного



    //Подтверждение о выходе
    override fun onBackPressed() {
        AlertDialog.Builder(this)
            .setTitle("Really Exit?")
            .setMessage("Are you sure you want to exit?")
            .setNegativeButton(android.R.string.no, null)
            .setPositiveButton(android.R.string.yes
            ) { _, _ ->
                super@MainActivity.onBackPressed()
                quit()
            }.create().show()
    }

    private fun quit() {
        val start = Intent(Intent.ACTION_MAIN)
        start.addCategory(Intent.CATEGORY_HOME)
        start.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        start.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(start)
    }

    //Кнопка списка избранного
    fun buttonSox(view: View) {
        val button6 = Intent (this, FilmActivity::class.java)
        startActivity(button6)
    }

    fun buttonOne(view: View) {
        val button1 = Intent(this, BadBoys::class.java)
        startActivity(button1)
        textView.setBackgroundColor(Color.RED)
        textView2.setBackgroundColor(Color.WHITE)
        textView3.setBackgroundColor(Color.WHITE)
        textView4.setBackgroundColor(Color.WHITE)
    }

    fun buttonTwo(view: View) {
        val button2 = Intent(this, TheMatrix::class.java)
        startActivity(button2)
        textView2.setBackgroundColor(Color.RED)
        textView.setBackgroundColor(Color.WHITE)
        textView3.setBackgroundColor(Color.WHITE)
        textView4.setBackgroundColor(Color.WHITE)
    }

    fun buttonThree(view: View) {
        val button3 = Intent(this, TheNetwork::class.java)
        startActivity(button3)
        textView3.setBackgroundColor(Color.RED)
        textView.setBackgroundColor(Color.WHITE)
        textView2.setBackgroundColor(Color.WHITE)
        textView4.setBackgroundColor(Color.WHITE)
    }

    fun buttonFour(view: View) {
        val button4 = Intent(this, TheWarcraft::class.java)
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