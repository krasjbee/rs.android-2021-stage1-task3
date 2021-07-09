package subtask1

import java.math.BigInteger

class Combinator {

    // TODO: Complete the following function
    /* C(k n) =  n!/(n-k)!k!
*/
    fun checkChooseFromArray(array: Array<Int>): Int? {
        val posterNumber = array[0]
        val maxColors = array[1]
        var c: Long = 0
        for (colorCount in 1..maxColors / 2 + 1) {
            c = factorial(maxColors) / (factorial(maxColors - colorCount) * factorial(colorCount))
//            println("poster nubmer $posterNumber max colors $maxColors")
//            println("color count $colorCount")
//            println("c $c")
            if (c >= posterNumber) return colorCount
        }
        return null
    }

    private fun factorial(n: Int): Long {
        if (n == 0) return 1
        return n * factorial(n - 1)
    }
}
