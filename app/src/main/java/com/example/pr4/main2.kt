package com.example.pr4

import android.Manifest
import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.provider.CallLog.Calls
import android.provider.ContactsContract
import android.provider.MediaStore
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat


class main2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        @SuppressLint("MissingPermission")

        var actionbar=supportActionBar

        actionbar!!.title="Features"
        actionbar.setDisplayHomeAsUpEnabled(true)

        val et_number=findViewById<EditText>(R.id.et_number)
        val btn_browser=findViewById<Button>(R.id.btn_browser)
        val btn_contact=findViewById<Button>(R.id.btn_contact)
        val btn_camera=findViewById<Button>(R.id.btn_camera)
        val btn_call=findViewById<Button>(R.id.btn_call)
        val btn_call_log=findViewById<Button>(R.id.btn_call_log)
        val btn_gallery=findViewById<Button>(R.id.btn_gallery)

        setupPermissions()

        btn_call.setOnClickListener(View.OnClickListener {
            val intent = Intent(Intent.ACTION_CALL)
            intent.data = Uri.parse("tel:" + et_number.getText())
            startActivity(intent)
        })

        btn_call_log.setOnClickListener(View.OnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.type =Calls.CONTENT_TYPE
            startActivity(intent)
        })

        btn_contact.setOnClickListener(View.OnClickListener {
            val intent = Intent(Intent.ACTION_PICK)
            intent.type = ContactsContract.Contacts.CONTENT_TYPE
            startActivity(intent)
        })

        btn_browser.setOnClickListener(View.OnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://www.google.com/")
            startActivity(intent)
        })

        btn_gallery.setOnClickListener(View.OnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("content://media/external/images/media/")
            startActivity(intent)
        })

        btn_camera.setOnClickListener(View.OnClickListener {
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivity(intent)
        })
    }
    private fun setupPermissions() {
        val permission = ContextCompat.checkSelfPermission(this,
            Manifest.permission.CALL_PHONE)

        if (permission != PackageManager.PERMISSION_GRANTED) {
            Log.i("noone", "Permission to Call has denied")
            makeRequest()
        }
    }

    private fun makeRequest() {
        val CALL_REQUEST_CODE =101
        ActivityCompat.requestPermissions(this,
            arrayOf(Manifest.permission.CALL_PHONE),
            CALL_REQUEST_CODE)
    }
}