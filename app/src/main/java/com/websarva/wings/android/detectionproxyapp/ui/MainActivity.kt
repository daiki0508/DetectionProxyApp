package com.websarva.wings.android.detectionproxyapp.ui

import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import com.websarva.wings.android.detectionproxyapp.R
import com.websarva.wings.android.detectionproxyapp.databinding.ActivityMainBinding
import com.websarva.wings.android.detectionproxyapp.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater).apply {
            setContentView(this.root)
        }

        // btConnectタップ時の処理
        binding.btConnect.setOnClickListener {
            // proxy検知
            getSystemService(ConnectivityManager::class.java).also { manager ->
                val currentNetwork = manager.activeNetwork
                manager.getLinkProperties(currentNetwork).also { linkProperties ->
                    if (linkProperties?.httpProxy == null){
                        Log.i("check", "Proxy is null.")
                        viewModel.connect()
                    }else{
                        Log.w("check", "Proxy detected.")
                        Toast.makeText(this, "Proxy detected.", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }

        // resultの通知
        viewModel.result.observe(this){
            Toast.makeText(this, if (it){
                "Connection Success!!"
            }else{
                "Connection Failure..."
            }, Toast.LENGTH_SHORT).show()
        }
    }
}