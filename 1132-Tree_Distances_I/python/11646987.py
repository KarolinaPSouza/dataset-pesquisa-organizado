from collections import deque

n = int(input())
adj = [[] for i in range(n)]

for _ in range(n-1):
    u, v = map(int, input().split())
    u -= 1; v -= 1
    adj[u].append(v)
    adj[v].append(u)

def bfs(source):
    queue = deque()
    queue.append((source, 0))
    visited = [False]*n
    visited[source] = True
    dist = [0]*n
    while queue:
        u, d = queue.pop()
        dist[u] = d
        for v in adj[u]:
            if not visited[v]:
                visited[v] = True
                queue.appendleft((v, d+1))
    return u, dist

source1, _ = bfs(0)
source2, dist1 = bfs(source1)
_, dist2 = bfs(source2)
dist = [max(dist1[i], dist2[i]) for i in range(n)]
print(" ".join(map(str, dist)))