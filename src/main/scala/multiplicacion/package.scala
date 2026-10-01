import scala.annotation.tailrec

package object multiplicacion {
  def PeasantAlgorithm(x: Int, y: Int): Int = {
    if (x == 0) 0 // Si "x" es 0, el resultado de la multiplicación es 0
    else if (x % 2 == 0) PeasantAlgorithm(x / 2, y + y) // Si "x" es par, se divide "x" y se suma "y" consigo mismo
    else PeasantAlgorithm(x / 2, y + y) + y // Si "x" es impar, se divide "x" entre 2 y se duplica "y", sumando "y" al resultado
  }

  def PeasantAlgorithmIt(x: Int, y: Int): Int = {
    @tailrec // Función recursiva auxiliar
    def loop(a: Int, b: Int, acc: Int): Int = {
      if (a == 0) acc // Termina la recursión cuando "a" es 0, retornando el acumulador
      else if (a % 2 == 0) loop(a / 2, b + b, acc) // Si "a" es par, se divide "a" entre 2 y se duplica "b", continuando la recursión
      else loop(a / 2, b + b, acc + b) // Si "a" es impar, se divide "a" entre 2 y se duplica "b", sumando "b" al acumulador y continuando la recursión
    }

    loop(x, y, 0) // Valores iniciales
  }

  def splitMultiply(x: Int, y: Int): Int = {

    // Verifica los digitos de cada numero
    val xDigit = x.toString.length
    val yDigit = y.toString.length

    // Si ambos enteros solo tienen un digito, retorna la multiplicación directa
    if (xDigit == 1 && yDigit == 1) {
      x * y
    } else {
      // en caso contrario, se realiza la recursión
      val n = math.max(xDigit, yDigit)
      val m = n / 2


      val pow_10_m = math.pow(10, m).toInt
      val pow10_m2 = pow_10_m * pow_10_m

      // Se realiza el split usando división y modulo por potencia de 10
      val xHigh = x / pow_10_m
      val xLow = x % pow_10_m
      val yHigh = y / pow_10_m
      val yLow = y % pow_10_m

      //Recursión
      val z2 = splitMultiply(xHigh, yHigh)
      val z1 = splitMultiply(xHigh, yLow)
      val z0 = splitMultiply(xLow, yHigh)
      val z3 = splitMultiply(xLow, yLow)

      val middle = z1 + z0
      val result = z2 * pow10_m2 + middle * pow_10_m + z3

      result
    }
      
  }

  def fastMultiply(x: Int, y: Int): Int = {
    if (x < 10 && y < 10) {
      // Si los enteros tienen solo un digito se hace la multiplicación directa
      x * y
    } else {
      // Se toma los digitos de cada numero
      val xDigit = x.toString.length
      val yDigit = y.toString.length

      // Determinar punto de corte
      val n = math.max(xDigit, yDigit)
      val m = n / 2

      // Calcular 10^m y su potencia
      val pow10_m = math.pow(10, m).toInt
      val pow10_2m = pow10_m * pow10_m

      // dividir usando división y modulo
      val xHigh = x / pow10_m
      val xLow = x % pow10_m
      val yHigh = y / pow10_m
      val yLow = y % pow10_m

      // Recursión
      val z0 = fastMultiply(xLow, yLow)
      val z1 = fastMultiply(xLow + xHigh, yLow + yHigh)
      val z2 = fastMultiply(xHigh, yHigh)

      val middleTerm = z1 - z2 - z0

      val part1 = z2 * pow10_2m
      val part2 = middleTerm * pow10_m

      part1 + part2 + z0
    }
  }
}