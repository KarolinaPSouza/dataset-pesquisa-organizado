from sys import stdin

n = int(stdin.readline())
grafo = [[] for _ in range(n + 1)]
for _ in range(n - 1):
    a, b = map(int, stdin.readline().split())
    grafo[a].append(b)
    grafo[b].append(a)

from collections import deque

def bfs(inicio, grafo, n):
    dist = [-1] * (n + 1)
    dist[inicio] = 0
    fila = deque([inicio])
    mais_longe = inicio
    while fila:
        u = fila.popleft()
        for v in grafo[u]:
            if dist[v] == -1:
                dist[v] = dist[u] + 1
                fila.append(v)
                if dist[v] > dist[mais_longe]:
                    mais_longe = v
    return mais_longe, dist[mais_longe]

x, _ = bfs(1, grafo, n)
_, d = bfs(x, grafo, n)

print(d)