package `01-kotlin-and-kotlin-standard-library`

fun printCar(car: Car?) {
    val isCoupe = car?.let {
        (it.doors <= 2)
    }
    if (isCoupe == true) {
        println("Coupes ar awesome")
    }
}

fun printCar2(car: Car?) {
    val isCoupe = car?.run {
        (this.doors <= 2)
    }
    if (isCoupe == true) {
        println("Coupes ar awesome")
    }
}

fun printCar3(car: Car?) {
    car?.also {
        it.doors = 4
    }.let {
        if (it?.doors != null && it.doors <= 2) {
            println("Coupes ar awesome")
        }
    }
}

fun printCar4(car: Car?) {
    car?.apply {
        doors = 4
    }.let {
        if (it?.doors != null && it.doors <= 2) {
            println("Coupes ar awesome")
        }
    }
}

fun main() {
}