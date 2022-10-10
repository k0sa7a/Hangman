import java.util.*
import kotlin.random.Random

val words = listOf("shoe", "jacket", "diver", "muffin", "spear", "truck", "nickel", "coal", "yellow", "grain")
var word = ""
val guesses = arrayListOf<Char>()
var remainingGuesses = 6
var mistakes = 0

fun main(args: Array<String>) {
    setupGame()
}

fun setupGame(){
    val wordIndex = Random.nextInt(words.size)
    word = words[wordIndex].uppercase(Locale.getDefault())
    println(word)
}