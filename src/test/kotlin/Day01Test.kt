import io.kotlintest.shouldBe
import org.junit.jupiter.api.Test

class DayOne {

    @Test
    fun `should calculate fuel quantity`() {
        SpaceCraftModule(mass = 12).fuelQuantity shouldBe 2
        SpaceCraftModule(mass = 14).fuelQuantity shouldBe 2
        SpaceCraftModule(mass = 1969).fuelQuantity shouldBe 654
        SpaceCraftModule(mass = 100756).fuelQuantity shouldBe 33583
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
        ).fuelQuantity shouldBe 34241
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