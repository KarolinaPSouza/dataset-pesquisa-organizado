from heapq import heappush, heappop

n, m = map(int, input().split())
adj = [[] for _ in range(n)]
inf = 10**18
edges = [None]*m

for i in range(m):
    u, v, w = map(int, input().split())
    u -= 1; v -= 1
    edges[i] = [u, v, w]

dist = [inf]*n
parent = [None]*n
dist[0] = 0

for _ in range(n):
    x = None
    for u, v, w in edges:
        if dist[v] > dist[u] + w:
            parent[v] = u
            dist[v] = dist[u] + w
            x = v

if x is None:
    print("NO")
    exit()

for _ in range(n):
    x = parent[x]

cycle = [x+1]
curr = x
while parent[curr] != x:
    curr = parent[curr]
    cycle.append(curr+1)
cycle.append(x+1)
cycle.reverse()
print("YES")
print(" ".join(map(str, cycle)))