import sys

def bellman_ford(n, edges):
    INF = 10**18
    dist = [INF] * (n + 1)
    parent = [-1] * (n + 1)

    is_there_cycle = -1  # Variable para detectar si hay un ciclo negativo
    dist[1] = 0  # Suponemos que el nodo 1 es el punto de partida

    # Relajamos las aristas n veces
    for i in range(n):  # Usamos i en lugar de _
        is_there_cycle = -1
        for vertice1, vertice2, peso in edges:  # Cambiamos u, v, d por vertice1, vertice2, peso
            if dist[vertice1] + peso < dist[vertice2]:
                dist[vertice2] = dist[vertice1] + peso
                parent[vertice2] = vertice1
                is_there_cycle = vertice2  # Si is_there_cycle cambia, hay una relajación en la iteración n

    if is_there_cycle == -1:
        print("NO")
        return

    # Encontrar el ciclo negativo
    for i in range(n):  # Usamos i en lugar de _
        is_there_cycle = parent[is_there_cycle]

    cycle = []
    node = is_there_cycle
    while True:
        cycle.append(node)
        if node == is_there_cycle and len(cycle) > 1:
            break
        node = parent[node]

    cycle.reverse()
    print("YES")
    print(" ".join(map(str, cycle)))

# Leer entrada
n, m = map(int, input().split())
edges = [tuple(map(int, input().split())) for _ in range(m)]

bellman_ford(n, edges)