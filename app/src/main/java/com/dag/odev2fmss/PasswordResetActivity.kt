package com.dag.odev2fmss

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.dag.odev2fmss.databinding.ActivityPasswordResetBinding

class PasswordResetActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPasswordResetBinding
    private lateinit var emailText: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPasswordResetBinding.inflate(layoutInflater)
        setContentView(binding.root)

        resetPasswordButtonClicked()
        onBackStackPressButton()
    }

    private fun resetPasswordButtonClicked() {
        binding.renewPasswordButton.setOnClickListener {
            emailText = binding.usernameEditText.text.toString()
            Toast.makeText(this,
                "$emailText : Mail Adresine Şifre Gönderilmiştir!",
                Toast.LENGTH_SHORT).show()
        }
    }

    /**
     * backScreenButton ile bir önceki sayfaya geçişi sağlanıyor.
     */
    private fun onBackStackPressButton() {
        binding.backScreenButton.setOnClickListener {
            Util.backStack(this, LoginScreenActivity())
        }
    }

}