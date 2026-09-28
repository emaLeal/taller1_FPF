import scala.annotation.tailrec

package object Multiplicacion {
  // Algoritmo de multiplicación campesino (lineal)
  def PeasantAlgorithm(x: Int, y: Int): Int = {
    if (x == 0) 0  // Si "x" es 0, el resultado de la multiplicación es 0
    else if (x % 2 == 0) PeasantAlgorithm(x/2, y+y) // Si "x" es par, se divide "x" y se suma "y" consigo mismo
    else PeasantAlgorithm(x/2, y+y) + y // Si "x" es impar, se divide "x" entre 2 y se duplica "y", sumando "y" al resultado
  }

  // Algoritmo de multiplicación campesino (iterativo)
  def PeasantAlgorithmIt(x: Int, y: Int): Int = {
  @tailrec // Función recursiva auxiliar
  def loop(a: Int, b: Int, acc: Int): Int = {
    if (a == 0) acc                             // Termina la recursión cuando "a" es 0, retornando el acumulador
    else if ( a % 2 == 0) loop(a/2, b+b, acc)   // Si "a" es par, se divide "a" entre 2 y se duplica "b", continuando la recursión
    else loop(a/2, b+b, acc + b)                // Si "a" es impar, se divide "a" entre 2 y se duplica "b", sumando "b" al acumulador y continuando la recursión
  }
  loop(x, y, 0)                                 // Valores iniciales
  }

  def splitMultiply(x: Int, y: Int): Int = {
    // Verifica los digitos de cada numero
    val xDigit = math.abs(x).toString.length
    val yDigit = math.abs(y).toString.length
    // Si ambos enteros solo tienen un digito, retorna la multiplicación directa
    if (xDigit == 1 && yDigit == 1) x * y

    
  }

  def fastMultiply(x: Int, y: Int): Int = {

  }
}