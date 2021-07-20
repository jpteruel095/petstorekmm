package com.pat.petstore_kmm.android

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.pat.petstore_kmm.PetStoreService
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class MainActivity : AppCompatActivity() {

    @DelicateCoroutinesApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tv: TextView = findViewById(R.id.text_view)
        this.lifecycleScope.launch(Dispatchers.IO) {
            val petObject = PetStoreService().getPetById(1)
            Log.i("pet", petObject.name.toString())
            lifecycleScope.launch(Dispatchers.Main) {
                tv.text = petObject.name.toString()
            }
        }
    }
}
