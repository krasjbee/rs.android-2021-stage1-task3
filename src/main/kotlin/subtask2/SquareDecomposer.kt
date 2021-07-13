package subtask2

import kotlin.math.sqrt

class SquareDecomposer {

    fun decomposeNumber(number: Int): Array<Int>? {
        return factor(number * number, number - 1)
    }

    private fun factor(number: Int, potentialNumber: Int): Array<Int>? {
        for (i in potentialNumber downTo 1) {
            val rem = number - i * i
            //recursion stop conditions
            if (rem == 0) return arrayOf(i)
            if (rem < 0) return null

            var nextCandidate = sqrt(rem.toDouble()).toInt()
            if (nextCandidate >= i) {
                nextCandidate = i - 1
            }
            val nextPotential = factor(rem, nextCandidate)
            if (nextPotential != null) return nextPotential + arrayOf(i)
        }
        return null
    }
}