import sys
from collections import deque
input = sys.stdin.readline

def bfs(start, n, adj):
    dist = [-1] * (n + 1)
    dist[start] = 0
    q = deque([start])
    farthest = start

    while q:
        node = q.popleft()
        for nei in adj[node]:
            if dist[nei] == -1:
                dist[nei] = dist[node] + 1
                q.append(nei)
                if dist[nei] > dist[farthest]:
                    farthest = nei
    return farthest, dist

# --- Input ---
n = int(input())
adj = [[] for _ in range(n + 1)]
for _ in range(n - 1):
    a, b = map(int, input().split())
    adj[a].append(b)
    adj[b].append(a)

# --- Step 1: find one endpoint of diameter ---
u, _ = bfs(1, n, adj)

# --- Step 2: find the other endpoint ---
v, dist_u = bfs(u, n, adj)

# --- Step 3: distances from v ---
_, dist_v = bfs(v, n, adj)

# --- Step 4: answer for each node ---
ans = [max(dist_u[i], dist_v[i]) for i in range(1, n + 1)]
print(*ans)