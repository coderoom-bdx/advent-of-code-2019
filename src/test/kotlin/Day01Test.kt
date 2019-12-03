import io.kotlintest.shouldBe
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

class DayOne {

    @Test
    fun `should calculate fuel quantity`() {
        SpaceCraftModule(mass = 12).fuelMass shouldBe 2
        SpaceCraftModule(mass = 14).fuelMass shouldBe 2
        SpaceCraftModule(mass = 1969).fuelMass shouldBe 966
        SpaceCraftModule(mass = 100756).fuelMass shouldBe 50346
    }

    @Test
    fun `should calculate fuel quantity for several modules`() {
        SpaceCraft(
            listOf(
                SpaceCraftModule(12),
                SpaceCraftModule(14),
                SpaceCraftModule(1969),
                SpaceCraftModule(100756)
            )
        ).fuelQuantity shouldBe 51316
    }

    @Test
    fun `should init spacecraft from string`() {
        SpaceCraft.from(
            """
            12
            14
            1969
            100756
        """.trimIndent()
        ) shouldBe SpaceCraft(
            listOf(
                SpaceCraftModule(12),
                SpaceCraftModule(14),
                SpaceCraftModule(1969),
                SpaceCraftModule(100756)
            )
        )
    }
}