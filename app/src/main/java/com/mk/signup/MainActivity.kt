package com.mk.signup

import android.app.Dialog
import android.media.Image
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.mk.signup.R.layout.dialog
import android.view.ViewGroup
import android.view.ViewParent




class MainActivity : AppCompatActivity() {
    var c = 0
    var list = listOf<String>("من فضلك ادخل كلمة المرور"
            , "من فضلك ادخل كلمة المرور"
            , "لو سمحت دخل كلمة المرور"
            , "بعد اذنك دخل كلمة المرور"
            , "للمرة الاخيرة هحذرك اكتب كلمة المرور"
            , "انا حذرتك وانت مسمعتش الكلام سلام بقي"
    )

    lateinit var uName: EditText
    lateinit var email: EditText
    lateinit var phoneNumber: EditText
    lateinit var password: EditText
    lateinit var nameText: String
    lateinit var emailText: String
    lateinit var phoneText: String
    lateinit var passwordText: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        uName = findViewById(R.id.user_name)
        email = findViewById(R.id.email)
        phoneNumber = findViewById(R.id.phone_number)
        password = findViewById(R.id.password)
    }

    fun click(view: View) {
        nameText = uName.getText().toString()
        emailText = email.getText().toString()
        phoneText = phoneNumber.getText().toString()
        passwordText = password.getText().toString()
        //Log.d("Logging","${nameText} , $emailText , $phoneText , $passwordText")
        if (passwordText == "" && nameText != "" && phoneText != "" && emailText != "") {
            showDialog()
            c++
        } else if (nameText == ""
                || emailText == ""
                || phoneText == ""
                || passwordText == "") {
            Toast.makeText(this, "من فضلك ادخل البيانات المطلوبة", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "تم تسجيل البيانات بنجاح", Toast.LENGTH_SHORT).show()
        }


    }

    private fun showDialog() {
        /*if(textD.parent != null)
            (textD.getParent() as ViewGroup).removeView(textD)*/

        var dialogBuilder = AlertDialog.Builder(this)

        dialogBuilder.setTitle("")
        dialogBuilder.setMessage(list[c])
        dialogBuilder.setCancelable(false)
        dialogBuilder.setPositiveButton("Ok", { _, _ ->
            if (c == list.size)
                finish()
        })

        var b = dialogBuilder.create()
        b.show()
    }
}
