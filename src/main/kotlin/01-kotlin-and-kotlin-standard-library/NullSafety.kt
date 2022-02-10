package `01-kotlin-and-kotlin-standard-library`

data class Car(val name: String, var doors: Int = 4) {
    fun drive() {}
}

fun main() {
    var car: Car? = null

    car = Car("Mercedes-Benz")
    car.drive()
    car?.drive()

    val realCar: Car = car ?: Car("Porsche")
    car!!.drive()

}