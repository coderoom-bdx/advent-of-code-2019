import io.kotlintest.shouldBe
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

class DayTwo {

    @Test
    fun `should decode opcode`() {
        MyOpcode.decode(listOf(1, 0, 0, 0, 99)) shouldBe listOf(2, 0, 0, 0, 99)

        MyOpcode.decode(listOf(2, 3, 0, 3, 99)) shouldBe listOf(2, 3, 0, 6, 99)

        MyOpcode.decode(listOf(2, 4, 4, 5, 99, 0)) shouldBe listOf(2, 4, 4, 5, 99, 9801)

        MyOpcode.decode(listOf(1, 1, 1, 4, 99, 5, 6, 0, 99)) shouldBe listOf(30, 1, 1, 4, 2, 5, 6, 0, 99)

        MyOpcode.decode(listOf(1, 1, 1, 2, 99, 1, 6, 0, 1, 0, 0, 0, 99)) shouldBe listOf(1, 1, 2, 2, 99, 1, 6, 0, 1, 0, 0, 0, 99)
    }

}