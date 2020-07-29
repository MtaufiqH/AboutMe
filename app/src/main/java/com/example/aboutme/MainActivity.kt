package com.example.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    lateinit var nameInput: EditText
    lateinit var nickname: TextView
    lateinit var doneButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nameInput = findViewById(R.id.nickname_edit)
        nickname = findViewById(R.id.nickname_id)
        doneButton = findViewById(R.id.button_done)

        doneButton.setOnClickListener {
            addNickname(it)
        }

        nickname.setOnClickListener {
            updateNickname(it)
        }



    }


    // will show nickname in the UI
    private fun addNickname(view: View) {
        nickname.text = nameInput.text
        nickname.visibility = View.VISIBLE
        nameInput.visibility = View.GONE
        view.visibility = View.GONE

    }

    // will activate editText and update the nickname
    private fun updateNickname(view: View) {
        nameInput.visibility= View.VISIBLE
        doneButton.visibility = View.VISIBLE
        view.visibility = View.GONE

        // set the focus of the edit text
        nameInput.requestFocus()

        // show keyboard
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(nameInput,0)

    }
}