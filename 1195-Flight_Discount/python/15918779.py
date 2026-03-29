import sys
from collections import deque
import heapq
from functools import cache

input = sys.stdin.readline

n,m = map(int,input().split())
edges = [tuple(map(int,input().split())) for _ in range(m)]

adj = [[] for _ in range(n+1)]
adjr = [[] for _ in range(n+1)]

for u,v,w in edges:
    adj[u].append((v,w))
    adjr[v].append((u,w))


def dj(s,a):
    pq = []
    heapq.heappush(pq,(0,s))
    d = [float('inf')]*(n+1)
    d[s] = 0

    while pq:
        dis,u = heapq.heappop(pq)
        if d[u]<dis:
            continue

        for v,w in a[u]:
            if d[v]>d[u]+w:
                d[v] = d[u]+w
                heapq.heappush(pq,(d[v],v))

    return d

d1 = dj(1,adj)
dn = dj(n,adjr)

ans = float('inf')
for u,v,w in edges:
    if d1[u] != float('inf') and dn[v] != float('inf'):
        ans = min(ans,d1[u]+dn[v]+w//2)


print(ans)