package com.example.hencoderpluskotlinhomework1

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.core.utils.save
import com.example.core.utils.toast
import com.example.core.utils.value
import com.example.hencoderpluskotlinhomework1.entity.User
import com.example.hencoderpluskotlinhomework1.widget.CodeView
import com.example.lesson.LessonActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {

  companion object {

    private const val userNameKey = "username"
    private const val passwordKey = "password"

  }

  private lateinit var userName: EditText
  private lateinit var password: EditText
  private lateinit var code: EditText

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    userName = findViewById(R.id.et_username)
    password = findViewById(R.id.et_password)
    code = findViewById(R.id.et_code)

    userName.setText(userNameKey.value)
    password.setText(passwordKey.value)

    val loginButton = findViewById<Button>(R.id.btn_login)
    val codeImage: CodeView = findViewById(R.id.code_view)
    loginButton.setOnClickListener(this)
    codeImage.setOnClickListener(this)
  }

  override fun onClick(v: View?) {
    if (v is CodeView) {
      v.updateCode()
    } else if (v is Button) {
      login()
    }
  }

  private fun login() {
    val username: String = userName.text.toString()
    val password: String = password.text.toString()
    val code: String = code.text.toString()

    val user = User(username, password, code)

    if (verify(user)) {
      save(userNameKey, username)
      save(passwordKey, password)
      startActivity(Intent(this, LessonActivity::class.java))
    }
  }

  private fun verify(user: User): Boolean {
    if (user.userName.isBlank() && user.userName.length < 4) {
      toast("用户名不合法")
      return false
    }
    if (user.password.isBlank() && user.password.length < 4) {
      toast("密码不合法")
      return false
    }
    return true
  }
}