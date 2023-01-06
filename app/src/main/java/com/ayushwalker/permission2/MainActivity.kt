package com.ayushwalker.permission2

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnDial.setOnClickListener {
            val perm:Int = ContextCompat.checkSelfPermission(this@MainActivity, Manifest.permission.CALL_PHONE)
            if(perm == PackageManager.PERMISSION_GRANTED) callNumber()
            else{
                ActivityCompat.requestPermissions(this@MainActivity, arrayOf(Manifest.permission.CALL_PHONE), 121)
            }
        }
    }
    private fun callNumber(){
        val telNo:String = etPhNo.text.toString()
        val i = Intent()
        i.action = Intent.ACTION_CALL
        i.data = Uri.parse("tel:${telNo}")
        startActivity(i)
    }

}