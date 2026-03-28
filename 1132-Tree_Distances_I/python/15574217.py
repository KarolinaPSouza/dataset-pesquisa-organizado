from collections import deque

n = int(input())
edges = [[] for _ in range(n)]
for _ in range(n-1):
    a,b = map(int,input().split())
    edges[a-1].append(b-1)
    edges[b-1].append(a-1)

def bfs(start):
    dist = [-1]*n
    q = deque([start])
    dist[start] = 0
    while q:
        u = q.popleft()
        for v in edges[u]:
            if dist[v] == -1:
                dist[v] = dist[u] + 1
                q.append(v)
    farthest_node = dist.index(max(dist))
    return dist, farthest_node
dist1, u = bfs(0)
dist2, v = bfs(u)
dist3, _ = bfs(v)
res = [max(dist2[i], dist3[i]) for i in range(n)]
print(*res)