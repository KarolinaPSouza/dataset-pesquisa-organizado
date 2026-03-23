from collections import deque

n = int(input())
edges = [[] for _ in range(n)]
for _ in range(n-1):
    a,b = map(int, input().split())
    edges[a-1].append(b-1)
    edges[b-1].append(a-1)

def bfs(start):
    dist = [-1]*n
    dist[start] = 0
    q = deque([start])
    while q:
        u = q.popleft()
        for v in edges[u]:
            if dist[v] == -1:
                dist[v] = dist[u] + 1
                q.append(v)
    farthest_node = dist.index(max(dist))
    max_dist = max(dist)
    return farthest_node, max_dist

# First BFS
u,_ = bfs(0)
# Second BFS
_,diameter = bfs(u)
print(diameter)