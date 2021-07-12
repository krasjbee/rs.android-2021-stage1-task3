package subtask3

import java.lang.StringBuilder
import kotlin.math.sign

class TelephoneFinder {

    private val neighbours: MutableMap<Int, MutableList<Int>> = mutableMapOf()

    init {
        //generate neighbours each time instance is created
        generateNeighbours()
    }

    // TODO: Complete the following function
    fun findAllNumbersFromGivenNumber(number: String): Array<String>? {
        //if given number is negative return null
        if (number.toInt().sign == -1) return null

        val output = mutableListOf<String>()
        for (index in number.indices) {
            neighbours[Character.getNumericValue(number[index])]?.forEach {
                val input = StringBuilder(number)
                input.replace(index, index + 1, it.toString())
                output.add(input.toString())
            }
        }
        return output.toTypedArray()
    }

    //generates map of neighbours for given numbers
    private fun generateNeighbours() {
        for (i in 0..9) {
            neighbours[i] = mutableListOf()
        }
        val numbers = listOf(
            listOf(1, 2, 3),
            listOf(4, 5, 6),
            listOf(7, 8, 9),
            listOf(null, 0, null)
        )
        val directions = listOf(
            Pair(1, 0),
            Pair(0, 1),
            Pair(-1, 0),
            Pair(0, -1)
        )
        for (row in numbers.indices) {
            for (column in numbers[row].indices) {
                directions.forEach { direction ->
                    val possibleNeighbour =
                        numbers.getOrNull(row + direction.first)?.getOrNull(column + direction.second)
                    if (possibleNeighbour != null && numbers[row][column] != null) {
                        neighbours[numbers[row][column]]!!.add(possibleNeighbour)
                    }
                }
            }
        }
    }
}
