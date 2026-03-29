# CSES 1195 - Flight Discount (two-Dijkstra solution, Python-optimized)
import sys, heapq

data = list(map(int, sys.stdin.buffer.read().split()))
it = iter(data)
n = next(it); m = next(it)

g  = [[] for _ in range(n + 1)]
gr = [[] for _ in range(n + 1)]
edges = []
append_g = g.__getitem__
append_gr = gr.__getitem__
edges_append = edges.append

for _ in range(m):
    a = next(it); b = next(it); w = next(it)
    append_g(a).append((b, w))
    append_gr(b).append((a, w))  # reversed
    edges_append((a, b, w))

INF = 10**18
heappush = heapq.heappush
heappop  = heapq.heappop

def dijkstra(G, s):
    dist = [INF]*(n+1)
    dist[s] = 0
    pq = [(0, s)]
    while pq:
        d, u = heappop(pq)
        if d != dist[u]:
            continue
        for v, w in G[u]:
            nd = d + w
            if nd < dist[v]:
                dist[v] = nd
                heappush(pq, (nd, v))
    return dist

dist1 = dijkstra(g, 1)   # 1 -> *
distN = dijkstra(gr, n)  # * -> n via reversed graph

ans = INF
for u, v, w in edges:
    du = dist1[u]
    dv = distN[v]
    if du != INF and dv != INF:
        # integer half as required by CSES
        val = du + (w // 2) + dv
        if val < ans:
            ans = val

print(ans)