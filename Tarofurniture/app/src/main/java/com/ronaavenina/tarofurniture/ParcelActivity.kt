package com.ronaavenina.tarofurniture

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ronaavenina.tarofurniture.model.User
import kotlinx.android.synthetic.main.activity_explicit_intent.*
import kotlinx.android.synthetic.main.activity_parcel.*
import kotlinx.android.synthetic.main.activity_parcel.btn_back
import kotlinx.android.synthetic.main.activity_parcel.txt_desc
import kotlinx.android.synthetic.main.activity_parcel.txt_harga
import kotlinx.android.synthetic.main.activity_parcel.txt_nama

class ParcelActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_USER = "extra_user "
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_parcel)

        val user = intent.getParcelableExtra<User>(EXTRA_USER) as User

        txt_nama.text = user.name
        txt_harga.text = user.harga
        txt_desc.text = user.desc

        btn_back.setOnClickListener {
            val backItem = Intent(this@ParcelActivity, MainActivity::class.java)
            startActivity(backItem)
        }

    }
}