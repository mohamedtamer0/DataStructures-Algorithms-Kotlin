package `18-quicksort`


fun <T : Comparable<T>> List<T>.quicksortNaive(): List<T> {
    if (this.size < 2) return this //1

    val pivot = this[this.size / 2]//2
    val less = this.filter { it < pivot } //3
    val equal = this.filter { it == pivot }
    val greater = this.filter { it > pivot }
    return less.quicksortNaive() + equal + greater.quicksortNaive()//4
}