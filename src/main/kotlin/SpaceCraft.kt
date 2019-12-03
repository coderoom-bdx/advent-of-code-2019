data class SpaceCraft(val modules: List<SpaceCraftModule>) {
    val fuelQuantity = modules.sumBy { it.fuelQuantity }

    companion object {
        fun from(input: String) =
            SpaceCraft(input
                .split("\n")
                .map { SpaceCraftModule(mass = it.toInt()) })
    }
}

data class SpaceCraftModule(val mass: Int) {
    val fuelQuantity: Int = (mass / 3) - 2
}
