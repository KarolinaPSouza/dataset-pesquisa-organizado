import sys
from collections import deque

input = sys.stdin.readline

n = int(input())
lAdj = [[] for _ in range(n + 1)]

for _ in range(n - 1):
    a, b = map(int, input().split())
    lAdj[a].append(b)
    lAdj[b].append(a)

def bfs(start, adj):
    dist = [-1] * (n + 1)
    dist[start] = 0
    q = deque([start])

    while q:
        node = q.popleft()
        for neighbor in adj[node]:
            if dist[neighbor] == -1:
                dist[neighbor] = dist[node] + 1
                q.append(neighbor)

    farthest_node = start
    max_dist = 0
    for i in range(1, n + 1):
        if dist[i] > max_dist:
            max_dist = dist[i]
            farthest_node = i

    return farthest_node, max_dist

distantNode, _ = bfs(1, lAdj)
_, diameter = bfs(distantNode, lAdj)

print(diameter)