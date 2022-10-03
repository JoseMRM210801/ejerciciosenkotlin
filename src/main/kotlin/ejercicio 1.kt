import java.math.RoundingMode
import java.text.DecimalFormat

fun main() {
    val df = DecimalFormat("#.##")
    df.roundingMode = RoundingMode.HALF_UP
    val cestita = listOf(
        345.67 to 20.0, 100.0 to 12.0, 1987.56 to 64.0, 218.6 to 10.0, 300.0 to 25.6, 765.78 to 17.0
    )
    println(df.format(retCestaTotal(cestita, { a, b -> descuento(a, b) }, { a -> iva(a) })))

}

fun descuento(precio: Double, porcentaje: Double) = precio - (precio * porcentaje / 100)


fun iva(precio: Double) = precio + (precio * 0.16)


fun retCestaTotal(cesta: List<Pair<Double, Double>>, dis: (Double, Double) -> Double, iva: (Double) -> Double): Double {

    var total = 0.0
    for (i in cesta.indices) {
        total += iva(dis(cesta[i].first, cesta[i].second))
    }
    return total
}

