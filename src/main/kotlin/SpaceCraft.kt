data class SpaceCraft(val modules: List<SpaceCraftModule>) {
    val fuelQuantity = modules.sumBy { it.fuelMass }

    companion object {
        fun from(input: String) =
            SpaceCraft(input
                .split("\n")
                .map { SpaceCraftModule(mass = it.toInt()) })
    }
}

data class SpaceCraftModule(val mass: Int) {
    val fuelMass: Int = mass.computeFuelMass()

    private fun Int.computeFuelMass(): Int {
        val fuelMass = (this / 3) - 2
        return if (fuelMass > 0) {
            fuelMass + fuelMass.computeFuelMass()
        } else 0
    }
}
