import sys
from collections import deque

sys.setrecursionlimit(300000)
input = sys.stdin.readline

def bfs(start, g, n):
    dist = [-1] * (n + 1)
    q = deque([start])
    dist[start] = 0
    last = start

    while q:
        u = q.popleft()
        last = u
        for v in g[u]:
            if dist[v] == -1:
                dist[v] = dist[u] + 1
                q.append(v)
    return last, dist


n = int(input())
g = [[] for _ in range(n + 1)]

for _ in range(n - 1):
    a, b = map(int, input().split())
    g[a].append(b)
    g[b].append(a)

# 1) First BFS from node 1 → find farthest node A
A, _ = bfs(1, g, n)

# 2) BFS from A → get distances da, also find farthest node B
B, da = bfs(A, g, n)

# 3) BFS from B → get distances db
_, db = bfs(B, g, n)

# 4) For each node, answer = max(dist to A, dist to B)
result = [str(max(da[i], db[i])) for i in range(1, n+1)]
print(" ".join(result))