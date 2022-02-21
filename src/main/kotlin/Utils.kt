


infix fun String.example(function: () -> Unit) {
    println("---Example of $this---")
    function()
    println()
}