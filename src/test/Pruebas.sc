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


// ============================================================
// splitMultiply  (recursivo de árbol)
// ============================================================

// Base limite: 1 vs 2 dígitos — la frontera entre caso base y recursión
splitMultiply(9, 9) == 9 * 9
splitMultiply(10, 10) == 10 * 10

// Digitos impares: m = n/2 no divide exacto (n=3,5,7)
splitMultiply(123, 456) == 123 * 456
splitMultiply(12345, 6789) == 12345 * 6789
splitMultiply(1234567, 7654321) == 1234567 * 7654321

// Ceros internos: la mitad baja puede quedar en 0
splitMultiply(1001, 1001) == 1001 * 1001
splitMultiply(101, 101) == 101 * 101
splitMultiply(1005, 2005) == 1005 * 2005

// Potencias de 10: xHigh puede quedar en 0 según el corte
splitMultiply(1000, 1000) == 1000 * 1000
splitMultiply(10000, 10000) == 10000 * 10000
splitMultiply(10, 100) == 10 * 100

// Desbalanceados: un operando con muchos menos dígitos
splitMultiply(12345, 7) == 12345 * 7
splitMultiply(7, 12345) == 7 * 12345
splitMultiply(1234, 5) == 1234 * 5

// Simetricos / 9s: peor caso para acarreos
splitMultiply(9999, 9999) == 9999 * 9999
splitMultiply(999999, 999999) == 999999 * 999999

// Desborde de int: verifica semántica módulo 2^32
splitMultiply(65535, 65535) == 65535 * 65535
splitMultiply(46341, 46341) == 46341 * 46341
splitMultiply(2147483647, 2147483647) == 2147483647 * 2147483647
splitMultiply(2147483647, 1) == 2147483647 * 1

// Encadenados: cuadrados palíndromos conocidos
splitMultiply(11, 11) == 11 * 11
splitMultiply(111, 111) == 111 * 111
splitMultiply(1111, 1111) == 1111 * 1111
splitMultiply(11111, 11111) == 11111 * 11111

// ============================================================
// FastMultiply  (iterativo logarítmico)
// ============================================================

// Base limite: 1 vs 2 dígitos — la frontera entre caso base y recursión
fastMultiply(9, 9) == 9 * 9
fastMultiply(10, 10) == 10 * 10

// Digitos impares: m = n/2 no divide exacto (n=3,5,7)
fastMultiply(123, 456) == 123 * 456
fastMultiply(12345, 6789) == 12345 * 6789
fastMultiply(1234567, 7654321) == 1234567 * 7654321

// Ceros internos: la mitad baja puede quedar en 0
fastMultiply(1001, 1001) == 1001 * 1001
fastMultiply(101, 101) == 101 * 101
fastMultiply(1005, 2005) == 1005 * 2005

// Potencias de 10: xHigh puede quedar en 0 según el corte
fastMultiply(1000, 1000) == 1000 * 1000
fastMultiply(10000, 10000) == 10000 * 10000
fastMultiply(10, 100) == 10 * 100

// Desbalanceados: un operando con muchos menos dígitos
fastMultiply(12345, 7) == 12345 * 7
fastMultiply(7, 12345) == 7 * 12345
fastMultiply(1234, 5) == 1234 * 5

// Simetricos / 9s: peor caso para acarreos
fastMultiply(9999, 9999) == 9999 * 9999
fastMultiply(999999, 999999) == 999999 * 999999

// Desborde de int: verifica semántica módulo 2^32
fastMultiply(65535, 65535) == 65535 * 65535
fastMultiply(46341, 46341) == 46341 * 46341
fastMultiply(2147483647, 2147483647) == 2147483647 * 2147483647
fastMultiply(2147483647, 1) == 2147483647 * 1

// Encadenados: cuadrados palíndromos conocidos
fastMultiply(11, 11) == 11 * 11
fastMultiply(111, 111) == 111 * 111
fastMultiply(1111, 1111) == 1111 * 1111
fastMultiply(11111, 11111) == 11111 * 11111