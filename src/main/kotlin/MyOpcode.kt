import MyOpcode.OperationType.*
import java.lang.IllegalStateException

object MyOpcode {
    fun decode(input: List<Int>): List<Int> {
        var inputTampon = input
        var operationType = OperationType.from(inputTampon[0])
        var index = 0
        while (operationType != END) {
            inputTampon = decodeFromIndex(index, inputTampon, operationType)
            index += 4
            operationType = OperationType.from(inputTampon[index])

        }
        return inputTampon
    }

    enum class OperationType(val integerValue: Int) {
        ADDITION(1) {
            override fun execute(firstOperand: Int, secondOperand: Int) = firstOperand + secondOperand
        },
        MULTIPLICATION(2) {
            override fun execute(firstOperand: Int, secondOperand: Int) = firstOperand * secondOperand
        },
        END(99) {
            override fun execute(firstOperand: Int, secondOperand: Int): Int {
                throw IllegalStateException()
            }
        };

        abstract fun execute(firstOperand: Int, secondOperand: Int): Int


        companion object {
            fun from(integerValue: Int): OperationType {
                return values().first { it.integerValue == integerValue }
            }
        }
    }

    private fun decodeFromIndex(
        startIndex: Int,
        input: List<Int>,
        operationType: OperationType
    ): List<Int> {
        val firstOperandIndex = input[startIndex + 1]
        val secondOperandIndex = input[startIndex + 2]
        val resultIndex = input[startIndex + 3]

        val firstOperand = input[firstOperandIndex]
        val secondOperand = input[secondOperandIndex]

        val result = operationType.execute(firstOperand, secondOperand)

        val listResult = input.toMutableList()
        listResult[resultIndex] = result
        return listResult
    }

}
