import sys
input = sys.stdin.readline
oo = 1 << 50

n, m = map(int, input().split())
g = [[] for _ in range(2 * n)]
for _ in range(m):
    u, v, w = [int(i) - 1 for i in input().split()]; w += 1
    u1, v1 = u + n, v + n
    g[u].append((v, w))
    g[u1].append((v1, w))
    g[u].append((v1, w >> 1))

from heapq import heappop, heappush

def dijkstra(graph, start):
    n = len(graph)
    dist = [oo] * n
    dist[start] = 0

    queue = [(0, start)]
    while queue:
        path_len, v = heappop(queue)
        if path_len == dist[v]:
            for w, edge_len in graph[v]:
                if edge_len + path_len < dist[w]:
                    dist[w] = edge_len + path_len
                    heappush(queue, (edge_len + path_len, w))

    return dist



dis = dijkstra(g, 0)
print(dis[2 * n - 1])