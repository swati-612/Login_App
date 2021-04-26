package com.example.rbibank

import android.content.Context
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.login_frag.*
import kotlinx.android.synthetic.main.login_frag.et_pass
import kotlinx.android.synthetic.main.login_frag.et_user
import kotlinx.android.synthetic.main.login_frag.view.*
import kotlinx.android.synthetic.main.register_frag.*
import org.w3c.dom.Text

class LoginFrag : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var inflater = LayoutInflater.from(context)
        var view = inflater.inflate(R.layout.login_frag, container,false)

        //Spf activity

        var spf =activity?.getSharedPreferences("myspf23", Context.MODE_PRIVATE)


        view.btn_register.setOnClickListener {
            var fmanager = activity?.supportFragmentManager
            var tx = fmanager?.beginTransaction()
            tx?.replace(R.id.myframe, RegisterFrag())
            tx?.commit()
        }

        view.btn_login.setOnClickListener {

           // var uname = et_username.text.toString()
            //var pass = et_password.text.toString()
            var uname =et_user.text.toString()
            var pass =et_pass.text.toString()
            var username = spf?.getString("username", uname)
            var password = spf?.getString("password", pass)

Log.d("cred", username+"........"+password)

            if (TextUtils.isEmpty(uname)) {
                et_username.setError("please enter username first")
            }

            if (uname.equals(username) && pass.equals(password)) {


                var fmanager = activity?.supportFragmentManager
                var tx = fmanager?.beginTransaction()
                tx?.replace(R.id.myframe, WelcomeFrag())
                tx?.commit()

             Toast.makeText(activity, "logged in successfully", Toast.LENGTH_SHORT).show()

            } else{
                Toast.makeText(activity, "failed to loggin", Toast.LENGTH_SHORT).show()
            }
        }



        return view


    }
}