package com.example.androiddemo

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.androiddemo.configdatabase.AppDatabase
import com.example.androiddemo.databinding.ActivityMainBinding
import com.example.androiddemo.fragments.HomeFragment
import com.example.androiddemo.fragments.MyFragment
import com.example.androiddemo.fragments.PubFragment
import com.example.androiddemo.service.NetworkStateService


class MainActivity : AppCompatActivity() {

    private val homeFragment by lazy {
        HomeFragment()
    }

    private val pubFragment by lazy {
        PubFragment()
    }

    private val myFragment by lazy {
        MyFragment()
    }

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val noteDao = AppDatabase.getDatabase(this).noteDao()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            checkPermission()
        } else {
            //开启网路检测服务
            intent = Intent(this, NetworkStateService::class.java)
            startService(intent)
        }
        val fragmentManager = supportFragmentManager
        val transcation = fragmentManager.beginTransaction()
        transcation.replace(R.id.fragment_container, homeFragment)
        transcation.commit()
        binding.bottmoNavigationView.setOnItemSelectedListener {
            val transcation = fragmentManager.beginTransaction()
            when (it.itemId) {
                R.id.home -> {
                    transcation.replace(R.id.fragment_container, homeFragment)
                    transcation.commit()
                    return@setOnItemSelectedListener true
                }

                R.id.publish -> {
                    transcation.replace(R.id.fragment_container, pubFragment)
                    transcation.commit()
                    return@setOnItemSelectedListener true
                }

                R.id.my -> {
                    transcation.replace(R.id.fragment_container, myFragment)
                    transcation.commit()
                    return@setOnItemSelectedListener true
                }

                else -> false
            }
        }
    }

    fun checkPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.POST_NOTIFICATIONS) !=
            PackageManager.PERMISSION_GRANTED
        ) {
            requestPermissionLauncher.launch(Manifest.permission.POST_NOTIFICATIONS)
        } else {
            //开启网路检测服务
            intent = Intent(this, NetworkStateService::class.java)
            startService(intent)
        }
    }

    val requestPermissionLauncher =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted: Boolean ->
            if (isGranted) {
                //开启网路检测服务
                intent = Intent(this, NetworkStateService::class.java)
                startService(intent)
            } else {
                Toast.makeText(
                    MainApplicaiton.context,
                    "您需要通知权限用于汇报网络监听",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
}