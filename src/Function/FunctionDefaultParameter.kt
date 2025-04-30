package Function

fun FunctionDefaultParameter(name: String?, age: Int?, Birthday: String? = "18 Januari 1987") {
    println("Nama Saya $name Saya berumur $age, ulang tahun saya $Birthday")
}

fun main() {
    FunctionDefaultParameter("Jamal Arjuna Dwi Ridwansyah", 34)
}