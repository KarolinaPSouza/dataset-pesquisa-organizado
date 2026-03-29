n, m = map(int, input().split(" "))
edges = []
inf = 10**18

for _ in range(m):
    u, v, w = map(int, input().split(" "))
    edges.append((u, v, w))

dist = [inf]*(n+1)
parent = [0]*(n+1)
dist[1] = 0

x = None
for _ in range(n):
    x = None
    for u, v, w in edges:
        if dist[v] > dist[u] + w:
            parent[v] = u
            dist[v] = dist[u] + w
            x = v
if x == None:
    print("NO")
    exit()

for _ in range(n):
    x = parent[x]

curr = x
cycle = [x]
while parent[curr] != x:
    curr = parent[curr]
    cycle.append(curr)
cycle.append(x)
cycle.reverse()
print("YES")
print(" ".join(map(str, cycle)))