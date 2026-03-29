import sys
from collections import *
import heapq
input=lambda:sys.stdin.readline().rstrip("\r\n")

n,m=map(int,input().split())
edges=[]
for _ in range(m):
    edges.append(tuple(map(int,input().split())))


dist = [0] * (n + 1)
prev = [-1] * (n + 1)
x = -1


for it in range(n):
    for u, v, w in edges:
        if dist[u] + w < dist[v]:
            dist[v] = dist[u] + w
            prev[v] = u
            if it == n - 1:
                x = v

if x == -1:
    print("NO")
else:
    print("YES")
    for _ in range(n):
        x = prev[x]
    cycle = []
    cur = x
    start = x
    while True:
        cycle.append(cur)
        cur = prev[cur]
        if cur == start:
            break
    cycle.append(start)
    cycle.reverse()
    print(*cycle)