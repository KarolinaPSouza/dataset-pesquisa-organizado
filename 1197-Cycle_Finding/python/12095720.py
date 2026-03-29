import sys

def bellman_ford(n, edges):
    INF = 10**18
    dist = [INF] * (n + 1)
    parent = [-1] * (n + 1)

    x = -1
    dist[1] = 0  # Suponemos que el nodo 1 es el punto de partida

    # Relajamos las aristas n veces
    for _ in range(n):
        x = -1
        for u, v, d in edges:
            if dist[u] + d < dist[v]:
                dist[v] = dist[u] + d
                parent[v] = u
                x = v  # Si x cambia, hay una relajación en la iteración n

    if x == -1:
        print("NO")
        return

    # Encontrar el ciclo negativo
    for _ in range(n):
        x = parent[x]

    cycle = []
    node = x
    while True:
        cycle.append(node)
        if node == x and len(cycle) > 1:
            break
        node = parent[node]

    cycle.reverse()
    print("YES")
    print(" ".join(map(str, cycle)))

# Leer entrada
n, m = map(int, input().split())
edges = [tuple(map(int, input().split())) for _ in range(m)]

bellman_ford(n, edges)