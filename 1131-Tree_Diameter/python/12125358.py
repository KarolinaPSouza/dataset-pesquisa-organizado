import sys
from collections import deque

def leer_entrada():
    n = int(sys.stdin.readline().strip())
    arbol = [[] for _ in range(n + 1)]

    for _ in range(n - 1):
        a, b = map(int, sys.stdin.readline().split())
        arbol[a].append(b)
        arbol[b].append(a)

    return n, arbol

def bfs(inicio, arbol, n):
    cola = deque([inicio])
    distancias = [-1] * (n + 1)
    distancias[inicio] = 0
    mas_lejano = inicio

    while cola:
        nodo = cola.popleft()
        for vecino in arbol[nodo]:
            if distancias[vecino] == -1:
                distancias[vecino] = distancias[nodo] + 1
                cola.append(vecino)
                mas_lejano = vecino

    return mas_lejano, distancias[mas_lejano]

def diametro_arbol(n, arbol):
    if n == 1:
        return 0

    lejano, _ = bfs(1, arbol, n)
    _, diametro = bfs(lejano, arbol, n)

    return diametro

if __name__ == "__main__":
    n, arbol = leer_entrada()
    print(diametro_arbol(n, arbol))