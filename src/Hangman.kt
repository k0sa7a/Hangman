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

    for (i in word.indices) {
        guesses.add('_')
    }

    var running = true

    do {
        printGameStatus()
        println("Please enter a letter:")
        val input = readLine()?:""
        if (input == "") {
            println("That is not a valid input, please try again")
        } else {
            val letter = input[0].uppercaseChar()
            if (word.contains(letter)) {
                for (i in word.indices) {
                    if (word[i] == letter) {
                        guesses[i] = letter
                    }
                }
                if (!guesses.contains('_')) running = false
            } else {
                println("Sorry, that's not part of the word!")
                remainingGuesses--
                mistakes++
                if (mistakes == 6) running = false
            }
        }

    } while (running)

    if (mistakes == 6) {
        printGameStatus()
        println("Sorry, you lost! The word was: \"$word\"")
    } else {
        println("Congrats! You guessed the word: \"$word\"!")
    }
}

fun printGameStatus(){
    when(mistakes) {
        0 -> print0Mistakes()
        1 -> print1Mistake()
        2 -> print2Mistakes()
        3 -> print3Mistakes()
        4 -> print4Mistakes()
        5 -> print5Mistakes()
        6 -> print6Mistakes()
    }
    print("Word: ")
    for (element in guesses) {
        print("$element ")
    }
    if (remainingGuesses == 1) {
        println("\nYou have $remainingGuesses guess left")
    } else {
        println("\nYou have $remainingGuesses guesses left")
    }
}

fun print0Mistakes(){
    println("  |------|-")
    println("  |      | ")
    println("  |        ")
    println("  |        ")
    println("  |        ")
    println("  |        ")
    println(" /|\\      ")
    println("/ | \\     ")
}

fun print1Mistake(){
    println("  |------|-")
    println("  |      | ")
    println("  |      O ")
    println("  |        ")
    println("  |        ")
    println("  |        ")
    println(" /|\\      ")
    println("/ | \\     ")
}

fun print2Mistakes(){
    println("  |------|-")
    println("  |      | ")
    println("  |      O ")
    println("  |      | ")
    println("  |      | ")
    println("  |        ")
    println(" /|\\      ")
    println("/ | \\     ")
}

fun print3Mistakes(){
    println("  |------|-")
    println("  |      | ")
    println("  |      O ")
    println("  |     /| ")
    println("  |      | ")
    println("  |        ")
    println(" /|\\      ")
    println("/ | \\     ")
}

fun print4Mistakes(){
    println("  |------|-")
    println("  |      | ")
    println("  |      O ")
    println("  |     /|\\")
    println("  |      | ")
    println("  |        ")
    println(" /|\\      ")
    println("/ | \\     ")
}

fun print5Mistakes(){
    println("  |------|-")
    println("  |      | ")
    println("  |      O ")
    println("  |     /|\\")
    println("  |      | ")
    println("  |     /  ")
    println(" /|\\      ")
    println("/ | \\     ")
}

fun print6Mistakes(){
    println("  |------|-")
    println("  |      | ")
    println("  |      O ")
    println("  |     /|\\")
    println("  |      | ")
    println("  |     / \\")
    println(" /|\\      ")
    println("/ | \\     ")
}