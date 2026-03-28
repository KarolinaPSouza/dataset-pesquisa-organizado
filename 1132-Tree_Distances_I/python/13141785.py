from collections import deque

def bfs(start, graph, n):
    dist = [-1] * (n)
    q = deque([start])
    dist[start] = 0
    while q:
        node = q.popleft()
        for nei in graph[node]:
            if dist[nei] == -1:
                dist[nei] = dist[node] + 1
                q.append(nei)
    return dist

n = int(input())
graph = [[] for _ in range(n)]

for _ in range(n - 1):
    a, b = map(int, input().split())
    graph[a-1].append(b-1)
    graph[b-1].append(a-1)

# First BFS to find one endpoint of diameter
dist_from_1 = bfs(0, graph, n)
u = dist_from_1.index(max(dist_from_1))

# Second BFS from u to find the actual diameter and distances
dist_from_u = bfs(u, graph, n)
v = dist_from_u.index(max(dist_from_u))

# Third BFS from v
dist_from_v = bfs(v, graph, n)

# Result for each node: max distance to either u or v
result = []
for i in range(n):
    result.append(str(max(dist_from_u[i], dist_from_v[i])))

print(" ".join(result))