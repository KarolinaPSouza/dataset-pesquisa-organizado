import sys
from collections import defaultdict, deque
input = sys.stdin.readline

def build_adj_list(n, edges):
    graph = [[] for _ in range(n + 1)]
    for u, v in edges:
        graph[u].append(v)
        graph[v].append(u)
    return graph

def farthest_node(graph, start):
    visited = [False] * len(graph)
    q = deque([(start, 0)])
    visited[start] = True
    farthest = (start, 0)

    while q:
        node, dist = q.popleft()
        if dist > farthest[1]:
            farthest = (node, dist)
        for nei in graph[node]:
            if not visited[nei]:
                visited[nei] = True
                q.append((nei, dist + 1))
    return farthest

def bfs_distances(graph, start):
    dist = [-1] * len(graph)
    dist[start] = 0
    q = deque([start])
    while q:
        node = q.popleft()
        for nei in graph[node]:
            if dist[nei] == -1:
                dist[nei] = dist[node] + 1
                q.append(nei)
    return dist

n = int(input())
edges = [tuple(map(int, input().split())) for _ in range(n - 1)]

graph = build_adj_list(n, edges)
farth1 = farthest_node(graph, 1)[0]
farth2 = farthest_node(graph, farth1)[0]
dist1 = bfs_distances(graph, farth1)
dist2 = bfs_distances(graph, farth2)

out = []
for i in range(1, n + 1):
    out.append(str(max(dist1[i], dist2[i])))

sys.stdout.write(" ".join(out))
