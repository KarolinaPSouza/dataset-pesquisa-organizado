import sys
sys.setrecursionlimit(1 << 25)
input = sys.stdin.readline

from collections import deque

def bfs(start):
    dist = [-1] * (n + 1)
    q = deque([start])
    dist[start] = 0
    while q:
        node = q.popleft()
        for nei in graph[node]:
            if dist[nei] == -1:
                dist[nei] = dist[node] + 1
                q.append(nei)
    farthest = dist.index(max(dist))
    return farthest, dist

n = int(input())
graph = [[] for _ in range(n + 1)]
for _ in range(n - 1):
    u, v = map(int, input().split())
    graph[u].append(v)
    graph[v].append(u)

# First BFS to get one end of diameter
x, _ = bfs(1)
# Second BFS to get other end and distances from x
y, dist_x = bfs(x)
# Third BFS to get distances from y
_, dist_y = bfs(y)

# Final answer is max(dist_x[i], dist_y[i]) for all nodes
res = [str(max(dist_x[i], dist_y[i])) for i in range(1, n + 1)]
print(" ".join(res))