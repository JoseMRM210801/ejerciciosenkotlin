import java.math.RoundingMode
import java.text.DecimalFormat
import kotlin.math.pow

fun main() {

    val lista = listOf(10.0, 45.0, 234.0, 56.7, 234.9, 888.8)
    println((resta(lista) { a -> sumaCuadrados(a) }))
}

fun sumaCuadrados(valor: Double) = valor + (valor.pow(2))

fun resta(valores: List<Double>, cuadrados: (Double) -> Double): List<Double> {

    val l = mutableListOf<Double>()
    for (i in valores.indices) {
        val df = DecimalFormat("#.##")
        df.roundingMode = RoundingMode.HALF_UP
        l.add(df.format(cuadrados(valores[i]) - (valores[i] / 2.0)).toDouble())
    }

    return l
}