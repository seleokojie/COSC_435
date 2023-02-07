package edu.towson.cosc435.labsapp

val input = """
   Are you going to eat that?
   My parents and I went to a movie.
   The ham, green beans, mashed potatoes, and corn are gluten-free.
   Misha walked and looked around, but did not find anything!
   The incessant ticking and chiming echoed off the weathered walls of the clock repair shop.
""".trimIndent()

val input2 = "The quick brown fox"

interface IConverter {
    fun convert(input: String): String
}

// TODO - Create a class the implements the IConverter interface

/**
 * This function takes a string and converts it to Pig Latin by
 * taking the first letter of every word, moving it to the end of the word, and adding "ay".
 * Note that Original capitalization and punctuation should be preserved.
 * @param input The string to convert to Pig Latin
 */
fun convertToPigLatin(input: String): String {
    return input.split(" ").joinToString(" ") { word ->
        val firstLetter = word[0]
        val restOfWord = word.substring(1)
        val punctuation = if (word.last().isLetter()) "" else word.last()
        val capitalized = firstLetter.isUpperCase()
        val pigLatinWord = restOfWord + firstLetter.lowercaseChar() + "ay" + punctuation
        if (capitalized) pigLatinWord.replaceFirstChar { it.uppercaseChar() } else pigLatinWord
    }
}

fun main() {
    println(convertToPigLatin(input2))
}

main()
