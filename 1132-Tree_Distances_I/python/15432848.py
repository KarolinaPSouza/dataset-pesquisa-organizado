import sys
input = sys.stdin.readline
from collections import deque

def bfs(start, adj, n):
    dist = [-1] * (n + 1)
    q = deque([start])
    dist[start] = 0
    while q:
        v = q.popleft()
        for u in adj[v]:
            if dist[u] == -1:
                dist[u] = dist[v] + 1
                q.append(u)
    farthest = max(range(1, n+1), key=lambda x: dist[x])
    return farthest, dist

n = int(input())
adj = [[] for _ in range(n + 1)]

for _ in range(n - 1):
    a, b = map(int, input().split())
    adj[a].append(b)
    adj[b].append(a)

# Step 1: BFS from any node (1) to find node A
A, _ = bfs(1, adj, n)

# Step 2: BFS from A to find distances and endpoint B
B, distA = bfs(A, adj, n)

# Step 3: BFS from B to get distB[]
_, distB = bfs(B, adj, n)

# Step 4: answer for each node is max(distA, distB)
ans = [max(distA[i], distB[i]) for i in range(1, n+1)]
print(*ans)