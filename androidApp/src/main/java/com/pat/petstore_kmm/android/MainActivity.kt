package com.pat.petstore_kmm.android

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.pat.petstore_kmm.PetStoreService
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    @DelicateCoroutinesApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tv: TextView = findViewById(R.id.text_view)
        this.lifecycleScope.launch {
            val petObject = PetStoreService().getPetById(12L)
            tv.text = petObject.name
        }
    }
}
