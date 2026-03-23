import sys
from collections import deque
input = sys.stdin.readline

n = int(input())
tree = [[] for _ in range(n)]
for _ in range(n-1):
    a, b = map(int, input().split())
    a -= 1
    b -= 1
    tree[a].append(b)
    tree[b].append(a)

def bfs(start):
    dist = [-1]*n
    dist[start] = 0
    q = deque([start])
    while q:
        u = q.popleft()
        for v in tree[u]:
            if dist[v] == -1:
                dist[v] = dist[u] + 1
                q.append(v)
    farthest_node = dist.index(max(dist))
    max_dist = max(dist)
    return farthest_node, max_dist

# First BFS to find one endpoint of the diameter
u, _ = bfs(0)
# Second BFS from u to find the diameter
v, diameter = bfs(u)

print(diameter)