# CSES: Tree Distances I — O(n) with 3 BFS
import sys
from collections import deque
read = sys.stdin.buffer.readline

n = int(read())
adj = [[] for _ in range(n + 1)]
for _ in range(n - 1):
    a, b = map(int, read().split())
    adj[a].append(b)
    adj[b].append(a)

def bfs(start: int):
    dist = [-1] * (n + 1)
    q = deque([start])
    dist[start] = 0
    while q:
        u = q.popleft()
        for v in adj[u]:
            if dist[v] == -1:
                dist[v] = dist[u] + 1
                q.append(v)
    far = start
    for i in range(1, n + 1):
        if dist[i] > dist[far]:
            far = i
    return dist, far

# 1) farthest from 1 -> A
_, A = bfs(1)
# 2) distances from A -> distA and far end B
distA, B = bfs(A)
# 3) distances from B -> distB
distB, _ = bfs(B)

# 4) answer per node
out = [str(max(distA[i], distB[i])) for i in range(1, n + 1)]
print(" ".join(out))