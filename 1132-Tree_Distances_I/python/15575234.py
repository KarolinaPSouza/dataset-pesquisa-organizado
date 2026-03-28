import sys
from collections import deque
input = sys.stdin.readline

n = int(input())
g = [[] for _ in range(n)]
for _ in range(n-1):
    a,b = map(int, input().split())
    g[a-1].append(b-1)
    g[b-1].append(a-1)

def bfs(start):
    dist = [-1]*n
    q = deque()
    q.append(start)
    dist[start] = 0
    while q:
        u = q.popleft()
        for v in g[u]:
            if dist[v]==-1:
                dist[v] = dist[u]+1
                q.append(v)
    farthest_node = dist.index(max(dist))
    return dist, farthest_node

_, u = bfs(0)

d1, v = bfs(u)

d2, _ = bfs(v)

ans = [max(d1[i], d2[i]) for i in range(n)]
print(*ans)