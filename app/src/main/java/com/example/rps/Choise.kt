package com.example.rps

import androidx.annotation.IdRes

enum class Choise(@IdRes val resourceId: Int) {
    ROCK(R.id.button_rock),
    SCISSORS(R.id.button_scissors),
    PAPER(R.id.button_paper)
}