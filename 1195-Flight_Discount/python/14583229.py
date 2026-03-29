import sys, heapq

it = map(int, sys.stdin.buffer.read().split())

n, m = next(it), next(it)

graph = [[] for _ in range(2 * n + 1)]
for _ in range(m):
    a, b, c = next(it), next(it), next(it)
    graph[a].append((b, c))
    graph[n + a].append((n + b, c))
    graph[a].append((n + b, c // 2))

dist = [10**18] * (2 * n + 1)
dist[1] = 0

pq = [(0, 1)]
while pq:
    d, u = heapq.heappop(pq)
    if d != dist[u]:
        continue
    for v, w in graph[u]:
        nd = d + w
        if nd < dist[v]:
            dist[v] = nd
            heapq.heappush(pq, (nd, v))

sys.stdout.write(str(dist[2 * n]))