package com.example.aboutme

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    // variable with ActivityMainBinding type
    // it's automaticly create by Android Studio
    private lateinit var binding: ActivityMainBinding

    // reference data name from @MyName class
    private val myname: MyName = MyName("M. Taufiq Hidayat")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // use dataBindingUtil to setup databinding
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        // replace setContentView
        // setContentView(R.layout.activity_main)


        /* Replace findviewbyid with Binding
         * nameInput = findViewById(R.id.nickname_edit)
         * nickname = findViewById(R.id.nickname_id)
         * doneButton = findViewById(R.id.button_done)
         */

        // access the name of @MyName data class
        binding.myName = myname



        with(binding) {
            buttonDone.setOnClickListener {
                addNickname(it)
            }

            nicknameId.setOnClickListener {
                updateNickname(it)

            }
        }

    }


    // will show nickname in the UI
    private fun addNickname(view: View) {
        with(binding) {
            myName?.nickname = nicknameEdit.text.toString()
            invalidateAll()
            nicknameId.visibility = View.VISIBLE
            nicknameEdit.visibility = View.GONE
            view.visibility = View.GONE
        }


    }

    // will activate editText and update the nickname
    private fun updateNickname(view: View) {
        binding.apply {
            nicknameEdit.visibility = View.VISIBLE
            buttonDone.visibility = View.VISIBLE
            view.visibility = View.GONE

            // set the focus of the edit text
            nicknameEdit.requestFocus()

            // show keyboard
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.showSoftInput(nicknameEdit, 0)

        }

    }
}