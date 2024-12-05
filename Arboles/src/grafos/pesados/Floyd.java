package grafos.pesados;

//Floyd es la alternativa mas elegante y mas directa que el algoritmo de disjkstra, se asemeja a warshall
//ocupa una matriz de adyacencias on peso, con ciertos detalles
//  la diagonal principal se rellena con ceros, (no se usa)
//  se respetan las demas adyacencias, y donde no hay adyacencia se rellena con infinitos(o el valor maximo posible del integer)
//  esa es la matriz inicial
//toca pivotear, Matriz Po(fila 0, columna 0),
//if(M[1,2]>(M[1,0]+M[0,2]))M[1,2]=M[1,0]+[0,2]
//si se quiere saber por que camino se toma el costo minimo, se crea otra matriz inicial (Predecesores)
//  las que no se usan se marcan con indice inválido (M[i,i]=-1), los demas se marcan con su columna
//si se cumple el if, entonces Predecesores[i,j]= pivote
//ejemplo
//   0  1  2  3  4        0  1  2  3  4
//0[ 0  1  n  n  n ]  0 [ -  1  2  3  4 ]
//1[ n  0  n  4  7 ]  1 [ 0  -  2  3  4 ]
//2[ 3  2  0  n  4 ]  2 [ 0  1  -  3  4 ]
//3[ 6  n  n  0  2 ]  3 [ 0  1  2  -  4 ]
//4[ n  n  n  3  0 ]  4 [ 0  1  2  3  - ]
//P0, P[1,3]=7
//   0  1  2  3  4        0  1  2  3  4
//0[ 0  1  n  n  n ]  0 [ -  1  2  3  4 ]
//1[ n  0  n  4  7 ]  1 [ 0  -  2  3  4 ]
//2[ 3  2  0  n  4 ]  2 [ 0  1  -  3  4 ]
//3[ 6  7  n  0  2 ]  3 [ 0  0  2  -  4 ]
//4[ n  n  n  3  0 ]  4 [ 0  1  2  3  - ]
//P1, P[0,3]=5, P[0,4]=8, P[2,3]=6
//   0  1  2  3  4        0  1  2  3  4
//0[ 0  1  n  5  8 ]  0 [ -  1  2  1  1 ]
//1[ n  0  n  4  7 ]  1 [ 0  -  2  3  4 ]
//2[ 3  2  0  6  4 ]  2 [ 0  1  -  1  4 ]
//3[ 6  7  n  0  2 ]  3 [ 0  0  2  -  4 ]
//4[ n  n  n  3  0 ]  4 [ 0  1  2  3  - ]
//P2, nil
//   0  1  2  3  4        0  1  2  3  4
//0[ 0  1  n  5  8 ]  0 [ -  1  2  1  1 ]
//1[ n  0  n  4  7 ]  1 [ 0  -  2  3  4 ]
//2[ 3  2  0  6  4 ]  2 [ 0  1  -  1  4 ]
//3[ 6  7  n  0  2 ]  3 [ 0  0  2  -  4 ]
//4[ n  n  n  3  0 ]  4 [ 0  1  2  3  - ]
//P3, P[0,4]=7, P[1,0]=10, P[1,4]=6, P[4,0]=9, P[4,1]=10
//   0  1  2  3  4        0  1  2  3  4
//0[ 0  1  n  5  7 ]  0 [ -  1  2  1  3 ]
//1[10  0  n  4  6 ]  1 [ 3  -  2  3  3 ]
//2[ 3  2  0  6  4 ]  2 [ 0  1  -  1  4 ]
//3[ 6  7  n  0  2 ]  3 [ 0  0  2  -  4 ]
//4[ 9 10  n  3  0 ]  4 [ 3  3  2  3  - ]
//P4, nil
//   0  1  2  3  4        0  1  2  3  4
//0[ 0  1  n  5  7 ]  0 [-1  1  2  1  3 ]
//1[10  0  n  4  6 ]  1 [ 3 -1  2  3  3 ]
//2[ 3  2  0  6  4 ]  2 [ 0  1 -1  1  4 ]
//3[ 6  7  n  0  2 ]  3 [ 0  0  2 -1  4 ]
//4[ 9 10  n  3  0 ]  4 [ 3  3  2  3 -1 ]

//hay camino entre dos vertices
//V1->V5? 0->4=7
//0->4
//0->3->4
//(0->3)^(3->4)
//(0->1->3)->4
//((0->1)^(1->3))->4
//(0->1->3)->4
//0->1->3->4

//0 C
//1 B
//2 X
//3 F
//4 Y
//   0  1  2  3  4        0  1  2  3  4
//0[ 0 55 95 30 115]  0 [-1  1  2  1  3 ]
//1[65  0 40 95 60 ]  1 [ 3 -1  2  3  3 ]
//2[ 3  2  0  6  4 ]  2 [ 0  1 -1  1  4 ]
//3[ 6  7  n  0  2 ]  3 [ 0  0  2 -1  4 ]
//4[ 9 10  n  3  0 ]  4 [ 3  3  2  3 -1 ]
public class Floyd {
}
