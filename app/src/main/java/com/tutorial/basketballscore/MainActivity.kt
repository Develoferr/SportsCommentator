package com.tutorial.basketballscore

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
    import androidx.lifecycle.ViewModelProvider
import com.tutorial.basketballscore.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        binding.mainViewModel = viewModel
        binding.lifecycleOwner = this
        binding.imageSend.setOnClickListener { openResultActivity() }
    }

    private fun openResultActivity() {
        val intent = Intent(this, ResultActivity::class.java)
        intent.putExtra("local_score", viewModel.localScoreLiveData.value)
        intent.putExtra("visitor_score", viewModel.visitorScoreLiveData.value)
        startActivity(intent)
    }
}