package com.tutorial.basketballscore

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tutorial.basketballscore.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    private lateinit var bundle: Bundle
    private var localScore: Int = 0
    private var visitorScore: Int = 0


    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        bundle = intent.extras!!
        localScore = bundle.getInt("local_score")
        visitorScore = bundle.getInt("visitor_score")
        binding.textMatchScore.text = "$localScore - $visitorScore"
        when {
            (localScore >  visitorScore) -> binding.textMatchResult.text = "Local Team Wins!!"
            (localScore == visitorScore) -> binding.textMatchResult.text = "It's a Tie!!"
            (localScore <  visitorScore) -> binding.textMatchResult.text = "Visitor Team Wins!!"
        }
    }
}