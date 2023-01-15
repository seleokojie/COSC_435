package edu.towson.cosc435.labsapp

val INPUT = """
   Are you going to eat that?
   My parents and I went to a movie.
   The ham, green beans, mashed potatoes, and corn are gluten-free.
   Misha walked and looked around, but did not find anything!
   The incessant ticking and chiming echoed off the weathered walls of the clock repair shop.
""".trimIndent()

interface IConverter {
    fun convert(input: String): String
}

// TODO - Create a class the implements the IConverter interface

fun main() {
    println(INPUT)
    // TODO - Convert each line of the input into PigLatin.
    // NOTE: You cannot use a for loop or an if statement!
}

main()
