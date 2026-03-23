import sys
from collections import defaultdict

def dfs_iter(start, graph, n):
    dist = [-1] * (n + 1)
    stack = [(start, -1, 0)]
    far, far_d = start, 0
    while stack:
        u, p, d = stack.pop()
        if dist[u] != -1:
            continue
        dist[u] = d
        if d > far_d:
            far, far_d = u, d
        for v in graph[u]:
            if v != p:
                stack.append((v, u, d + 1))
    return far, far_d

data = list(map(int, sys.stdin.buffer.read().split()))
it = iter(data)
n = next(it)

if n == 1:
    print(0)
    sys.exit(0)

graph = defaultdict(list)
for _ in range(n - 1):
    a = next(it); b = next(it)
    graph[a].append(b)
    graph[b].append(a)

start = 1
if graph:
    start = next(iter(graph))

u, _ = dfs_iter(start, graph, n)
_, diam = dfs_iter(u, graph, n)
print(diam)