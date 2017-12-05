import java.util.NoSuchElementException

import scala.collection.mutable
import scala.collection.mutable.LinkedHashMap
import scala.collection.mutable.ArrayBuffer
import collection.mutable

//http://exercism.io/exercises/scala/scrabble-score/readme

object Scrabble extends App{
  Scoring.scrabbleScore
}

object Scoring
{
  def scrabbleScore: Unit =
  {
    var score = 0     //Will be added to based on each letter inputted
    var word = ""     //The word that's typed in to calculate its score

    while(word != " ")
      {
        val letterValues = Map("A" -> 1, "E" -> 1, "I" -> 1, "O" -> 1, "U" -> 1, "L" -> 1, "N" -> 1, "R" -> 1, "S" -> 1, "T" -> 1,
                               "D" -> 2, "G" -> 2,
                               "B" -> 3, "C" -> 3, "M" -> 3, "P" -> 3,
                               "F" -> 4, "H" -> 4, "V" -> 4, "W" -> 4, "Y" -> 4,
                               "K" -> 5,
                               "J" -> 8, "X" -> 8,
                               "Q" -> 10, "Z" -> 10)

        var count = 0

        while (count != 2) {
          try {
            word = scala.io.StdIn.readLine("Please enter a word: ")

            for (letter <- word.toUpperCase) //Cycles through each letter in the word typed in
            {
              val result = letter //Each letter is stored into a variable
              println(result + " = " + letterValues(letter + "")) //Displays what each letter's value is

              score += letterValues(letter + "") //Adds the value of each letter onto the score
            }
            count += 1
            println("Total score for the word: " + word + " = " + score) //Displays the total score
            score = 0 //Returns the score value back to 0 so it doesn't keep adding onto it within the loop
            println()
          }

          catch {
            case e: NoSuchElementException => println("Your input contains a non-Scrabble character, try again")
              println()
          }
        }
        println(" wins this round")
        println()
      }
  }
}
