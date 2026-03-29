import sys
import heapq
from collections import deque
sys.setrecursionlimit(10**9)

vert, edges = map(int,input().split())
graph = [[] for i in range(vert+1)]
dist = [sys.maxsize for i in range(vert+1)]
vis = [-1 for i in range(vert+1)]
par = [-1 for i in range(vert+1)]

for i in range(edges) :
    n,m,c = map(int, input().split())
    graph[n].append((m,c))
dist[1] = 0 

for _ in range(vert-1) :
    for i in range(1,vert+1) :
        for j,k in graph[i] :
            if (k + dist[i] < dist[j]) :
                dist[j] = k + dist[i]
                par[j] = i
x = -1
for i in range(1,vert+1) :
    for j,k in graph[i] :
        if (k + dist[i] < dist[j]) :
            x = j
            par[j] = i
            print('YES')
            for _ in range(vert) :
                x = par[x]
            ans = [x]
            y = par[x]
            count = 1
            while y != x :
                ans.append(y)
                y = par[y]
                count += 1
            ans.append(x)
            for a in range(count,-1,-1) :
                print(ans[a],end=' ')
            sys.exit(0)

print('NO')