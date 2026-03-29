from collections import defaultdict
import copy
inf = int(1e18)


n, m = map(int, input().split())
connections = []
graph = defaultdict(list)
for _ in range(m):
 a, b, c = list(map(int,input().split()))
 connections.append([a-1, b-1, c])
 graph[a-1].append([b-1, c])


dist = [inf]*n
dist[0] = 0
realaxant = [-1]*n

for _ in range(n):
 x = -1
 for u, v, w in connections:
  if dist[u] + w < dist[v]:
   dist[v] = dist[u] + w
   realaxant[v] = u
   x = v

if x == -1:
 print("NO")
 exit()

for _ in range(n):
 x = realaxant[x]

cycle = []
v = x
while True:
 cycle.append(v+1)
 if v == x and len(cycle) > 1:
  break
 v = realaxant[v]

cycle = cycle[::-1]
print("YES")
print(*cycle)