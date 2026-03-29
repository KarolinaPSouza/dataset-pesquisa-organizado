import heapq
import sys
import math

input = sys.stdin.readline
INF = int(1e18)

def dijkstra(start, grafico_k, distancia):
    q = [(0, start)]
    distancia[start] = 0

    while q:
        dist, u = heapq.heappop(q)
        if distancia[u] < dist:
            continue
        for v in grafico_k[u]:
            if distancia[v[0]] > dist + v[1]:
                distancia[v[0]] = dist + v[1]
                heapq.heappush(q, (dist + v[1], v[0]))

n, m = map(int, input().split())
start = 1
end = n
graph1 = [[] for _ in range(n+1)]
graph2 = [[] for _ in range(n+1)]
distance1 = [INF] * (n+1)
distance2 = [INF] * (n+1)
edges = []

for _ in range(m):
    a, b, c = map(int, input().split())
    graph1[a].append((b, c))
    graph2[b].append((a, c))
    edges.append((a, b, c))

dijkstra(start, graph1, distance1)
dijkstra(end, graph2, distance2)

minimo = INF

for e in edges:
    minimo = min(minimo, distance1[e[0]] + math.floor(e[2]/2) + distance2[e[1]])

print(minimo)