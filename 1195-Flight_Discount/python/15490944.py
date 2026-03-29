import sys
from collections import *
import heapq
input=lambda:sys.stdin.readline().rstrip("\r\n")

n,m=map(int,input().split())
g=[[]for _ in range(n)]
for _ in range(m):
    a,b,w=map(int,input().split())
    a-=1;b-=1
    g[a].append((b,w))
dist=[float("inf")]*n
dist[0]=0

q=[(0, 0)]
while q:
    w,at=heapq.heappop(q)
    if w>dist[at]:continue
    for neigh,ww in g[at]:
        if w+ww < dist[neigh]:
            dist[neigh]=w+ww
            heapq.heappush(q,(w+ww, neigh))

dist_w = [float("inf")]*n
q = [(0,0)]
dist_w[0]=0
while q:
    w,at=heapq.heappop(q)
    if w>dist_w[at]:continue
    for neigh,ww in g[at]:
        if w+ww < dist_w[neigh]:
            dist_w[neigh]=w+ww
            heapq.heappush(q, (w+ww, neigh))
        if dist[at]+ww//2 < dist_w[neigh]:
            dist_w[neigh]=dist[at]+ww//2
            heapq.heappush(q, ( dist_w[neigh],neigh))

print(dist_w[-1])