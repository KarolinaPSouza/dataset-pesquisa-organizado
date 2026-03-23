from collections import deque
import sys

input = sys.stdin.readline
n = int(input().strip())
adj = [[] for _ in range(n+1)]
for _ in range(n-1):
    a,b = map(int, input().split())
    adj[a].append(b)
    adj[b].append(a)

def bfs(src):
    dist = [-1]*(n+1)
    q = deque([src])
    dist[src] = 0
    far = src
    while q:
        v = q.popleft()
        for to in adj[v]:
            if dist[to] == -1:
                dist[to] = dist[v] + 1
                q.append(to)
                if dist[to] > dist[far]:
                    far = to
    return far, dist

# first BFS from 1 (exists since n>=1)
u, _ = bfs(1)
# BFS from u to get diameter
_, dist = bfs(u)
print(max(dist[1:]))   # ignore index 0