package com.example.rbibank

import android.app.backup.SharedPreferencesBackupHelper
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.login_frag.*
import kotlinx.android.synthetic.main.register_frag.*
import kotlinx.android.synthetic.main.register_frag.et_password
import kotlinx.android.synthetic.main.register_frag.et_username
import kotlinx.android.synthetic.main.register_frag.view.*

class RegisterFrag : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var inflater = LayoutInflater.from(context)
        var view = inflater.inflate(R.layout.register_frag, container, false)


        var spf = activity?.getSharedPreferences("myspf23", Context.MODE_PRIVATE)


        var editor : SharedPreferences.Editor? = spf?.edit()


       view.final_register.setOnClickListener {

            var username = et_username.text.toString()
            var password = et_password.text.toString()


           editor?.putString("username", username)
           editor?.putString("password", password)
           editor?.commit()


           Toast.makeText(activity, "Data Registerd Successfully", Toast.LENGTH_SHORT).show()

           var fmanager = activity?.supportFragmentManager
           var tx = fmanager?.beginTransaction()
           tx?.replace(R.id.myframe, LoginFrag())
           tx?.commit()

       }

        return view
    }
}



