package object Multiplicacion {
  def PeasantAlgorithm(x: Int, y: Int): Int = {

  }

  def PeasantAlgorithmIt(x: Int, y: Int): Int = {

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