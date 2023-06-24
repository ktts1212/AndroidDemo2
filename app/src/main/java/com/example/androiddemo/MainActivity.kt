package com.example.androiddemo

<<<<<<< HEAD
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
=======
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.drawable.toBitmap
import com.example.androiddemo.config_database.AppDatabase
import com.example.androiddemo.databinding.ActivityMainBinding
import com.example.androiddemo.entities.Note
import com.example.androiddemo.fragments.HomeFragment
import com.example.androiddemo.fragments.MyFragment
import com.example.androiddemo.fragments.PubFragment
import com.example.androiddemo.utils.bitmaptoblob
>>>>>>> bffdb80ef3f495591b81abeabae79cb55390cb4a


class MainActivity : AppCompatActivity() {

<<<<<<< HEAD
=======
//    companion object{
//        val noteDao=AppDatabase.getDatabase(this).noteDao()
//    }

>>>>>>> bffdb80ef3f495591b81abeabae79cb55390cb4a
    private val homeFragment by lazy {
        HomeFragment()
    }

    private val pubFragment by lazy {
        PubFragment()
    }

    private val myFragment by lazy {
        MyFragment()
    }
<<<<<<< HEAD

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
=======
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fragmentManager=supportFragmentManager
        val transcation=fragmentManager.beginTransaction()
        transcation.replace(R.id.fragment_container,homeFragment)
        transcation.commit()
        binding.bottmoNavigationView.setOnItemSelectedListener {
                val transcation=fragmentManager.beginTransaction()
                when(it.itemId){
                    R.id.home->{
                        transcation.replace(R.id.fragment_container,homeFragment)
                        transcation.commit()
                        return@setOnItemSelectedListener true
                    }
                    R.id.publish->{
                        transcation.replace(R.id.fragment_container,pubFragment)
                        transcation.commit()
                        return@setOnItemSelectedListener true
                    }
                    R.id.my->{
                        transcation.replace(R.id.fragment_container,myFragment)
                        transcation.commit()
                        return@setOnItemSelectedListener true
                    }
                    else->false
                }
        }
    }

//    fun addData(){
//        val bitmap=(resources.getDrawable(R.drawable.img_1,null)).toBitmap()
//        val note1= Note("家人们谁懂啊", "今天要去吃好吃的", bitmaptoblob()
//    }
>>>>>>> bffdb80ef3f495591b81abeabae79cb55390cb4a
}