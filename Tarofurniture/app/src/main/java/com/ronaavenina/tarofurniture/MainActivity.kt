package com.ronaavenina.tarofurniture

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.ronaavenina.tarofurniture.model.User
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    companion object {
        const val REQUEST_CODE = 100
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_simple_intent.setOnClickListener {
            val simpleIntent = Intent(this@MainActivity, SimpleActivity::class.java)
            startActivity(simpleIntent)
        }

        btn_intent_with_data.setOnClickListener {
            val dataIntent = Intent(this@MainActivity, ExplicitIntentActivity::class.java)
            dataIntent.putExtra(ExplicitIntentActivity.EXTRA_NAME,"Mapple Wood Dining Table")
            dataIntent.putExtra(ExplicitIntentActivity.EXTRA_PRICE,"$140.00")
            dataIntent.putExtra(ExplicitIntentActivity.EXTRA_DESC,"Maple Wood Dinning Table adalah perpaduan warna antara white ivory dengan warna maple. Warna putih cocok untuk dipadukan dengan jenis warna apapun karena putih adalah warna netral, sedangkan maple adalah warna natural kayu sehingga Maple Wood Dining Table berkesan modern namun tetap natural. \n\n- Dimensi Meja: 160 x 80 x 95 Cm \n- Dimensi Kursi: 38 x 38 x 75 Cm")
            startActivity(dataIntent)
        }

        btn_intent_parcelable.setOnClickListener {
            val parcelIntent = Intent(this@MainActivity, ParcelActivity::class.java)
            val user = User( "Mapple Wood Dining Table", "$140.00", "Maple Wood Dinning Table adalah perpaduan warna antara white ivory dengan warna maple. Warna putih cocok untuk dipadukan dengan jenis warna apapun karena putih adalah warna netral, sedangkan maple adalah warna natural kayu sehingga Maple Wood Dining Table berkesan modern namun tetap natural. \n\n- Dimensi Meja: 160 x 80 x 95 Cm \n- Dimensi Kursi: 38 x 38 x 75 Cm")
            parcelIntent.putExtra(ParcelActivity.EXTRA_USER, user)
            startActivity(parcelIntent)
        }

        btn_implicit_intent.setOnClickListener {
            val phoneNumber = "089521770001"
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse( "tel:$phoneNumber"))
            startActivity(intent)
        }

        btn_intent_result.setOnClickListener {
            val intent = Intent(this@MainActivity, ResultActivity::class.java)
            startActivityForResult(intent, REQUEST_CODE)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode == 200){
            val color = data?.getStringExtra(ResultActivity.EXTRA_COLOR)
            Log.d("Color", color.toString())
            view_result.setBackgroundColor(Color.parseColor(color.toString()))
        }
    }
}