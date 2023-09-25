package com.example.rps

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class SecondActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        findViewById<Button>(R.id.exit).setOnClickListener(this)
    }

    override fun onStart() {
        super.onStart()
        val bundle = intent.extras
        val choiseOrdinal = bundle?.getInt(Choise::class.java.simpleName)
        choiseOrdinal ?: return
        val choise: Choise = Choise.values()[choiseOrdinal]
        val computerChoise = Choise.values()[Random.nextInt(Choise.values().size)]
        var result = "Your choice is: ${choise.name} \nComputer choice is: "
        result += computerChoise.name + "\n"
        if (choise == computerChoise) result = "Draw!"
        else if (choise == Choise.ROCK && computerChoise == Choise.SCISSORS) result += "You win!"
        else if (choise == Choise.PAPER && computerChoise == Choise.ROCK) result += "You win!"
        else if (choise == Choise.SCISSORS && computerChoise == Choise.PAPER) result += "You win!"
        else result += "Computer win!"
        findViewById<TextView>(R.id.screen).text = result
    }

    override fun onClick(view: View?){
        val button = view as? Button
        button ?: return
        if (button.id == findViewById<Button>(R.id.exit).id) finish()
    }
}