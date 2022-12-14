package com.dag.odev2fmss

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dag.odev2fmss.databinding.ActivityGetStartedScreenBinding

class GetStartedScreenActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGetStartedScreenBinding
    private lateinit var sharedPreferences: SharedPreferences
    private var isLogin: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGetStartedScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPreferences = getSharedPreferences("LOGIN", Context.MODE_PRIVATE)

        isLoginControllerSharedPreference()
        loginButtonIntent()
    }

    /**
     * sharedPreference de tutulan 'CHECK' boolean değeri sayesinde kullanıcı giriş yapmışsa HomeScreenActivity e yönlendirmesi yapılıyor.
     */
    private fun isLoginControllerSharedPreference() {
        isLogin = sharedPreferences.getBoolean("CHECK", isLogin)
        if (isLogin) {
            startActivity(Intent(this@GetStartedScreenActivity, HomeActivity::class.java))
            finish()
        }
    }

    /**
     * joinNowButton ile kullanıcı LoginScreenActivity e yönlendiriliyor.
     */
    private fun loginButtonIntent() {
        binding.joinNowButton.setOnClickListener {
            startActivity(Intent(this@GetStartedScreenActivity, LoginScreenActivity::class.java))
        }
    }

}