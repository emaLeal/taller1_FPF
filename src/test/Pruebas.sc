import multiplicacion.*

import scala.language.postfixOps


// ============================================================
// PeasantAlgorithm  (recursivo lineal)
// ============================================================

// Camino con ceros
PeasantAlgorithm(5731, 0) == 5731 * 0
PeasantAlgorithm(0, 5731) == 0 * 5731    //orden invertido
PeasantAlgorithm(0, 0) == 0 * 0

// Camino con unos
PeasantAlgorithm(99, 1) == 99 * 1
PeasantAlgorithm(1, 99) == 1 * 99     //orden invertido
PeasantAlgorithm(1, 1) == 1 * 1

// Camino todo impares
PeasantAlgorithm(99999, 88888) == 99999 * 88888
PeasantAlgorithm(88888, 99999) == 88888 * 99999   //orden invertido

// Camino todo pares
PeasantAlgorithm(1024, 1024) == 1024 * 1024

// Desbordamiento de enteros
PeasantAlgorithm(65535 , 65535) == 65535 * 65535
PeasantAlgorithm(5731, 32844361) == 5731 * 32844361

// ============================================================
// PeasantAlgorithmIt  (iterativo)
// ============================================================

// Camino con ceros
PeasantAlgorithmIt(0, 5731) == 0 * 5731
PeasantAlgorithmIt(5731, 0) == 5731 * 0 //orden invertido
PeasantAlgorithmIt(0, 0) == 0 * 0

// Camino con unos
PeasantAlgorithmIt(99, 1) == 99 * 1
PeasantAlgorithmIt(1, 99) == 1 * 99 //orden invertido
PeasantAlgorithmIt(1, 1) == 1 * 1

// Camino todo impares
PeasantAlgorithmIt(99999, 88888) == 99999 * 88888
PeasantAlgorithmIt(88888, 99999) == 88888 * 99999 //orden invertido

// Camino todo pares
PeasantAlgorithmIt(1024, 1024) == 1024 * 1024

// Desbordamiento de enteros
PeasantAlgorithmIt(65535 , 65535) == 65535 * 65535
PeasantAlgorithmIt(5731, 32844361) == 5731 * 32844361

// ============================================================
// CONSISTENCIA: las dos implementaciones deben coincidir
PeasantAlgorithm(5731 , 5731) == PeasantAlgorithmIt(5731 , 5731)
PeasantAlgorithmIt(0, 5731) == PeasantAlgorithm(0, 5731)
PeasantAlgorithmIt(99, 1) == PeasantAlgorithm(99, 1)
PeasantAlgorithmIt(99999, 88888) == PeasantAlgorithm(99999, 88888)
PeasantAlgorithmIt(1024, 1024) == PeasantAlgorithm(1024, 1024)
PeasantAlgorithmIt(65535 , 65535) == PeasantAlgorithm(65535 , 65535)
PeasantAlgorithmIt(5731, 32844361) == PeasantAlgorithm(5731, 32844361)


// Desbordamiento de enteros
splitMultiply(4, 12) == 4 * 12
splitMultiply(1000, 12) == 1000 * 12
splitMultiply(400, 2000) == 400 * 2000
splitMultiply(3849040, 282382) == 3849040 * 282382
splitMultiply(18882, 50000) == 18882 * 50000




fastMultiply(4, 12)