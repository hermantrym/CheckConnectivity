package com.intsyslab.checkconnectivity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.intsyslab.checkconnectivity.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var connectivityLiveData: ConnectionLiveData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        checkNetworkConnectionLiveData()
    }

    private fun checkNetworkConnectionLiveData() {
        connectivityLiveData = ConnectionLiveData(application)
        connectivityLiveData.observe(this) { isAvailable ->
            binding.apply {
                when (isAvailable) {
                    true -> tvConnection.text = getString(R.string.have_internet)
                    false -> tvConnection.text = getString(R.string.no_internet)
                }
            }
        }
    }
}