n, m = map(int, input().split())
edges = []

for _ in range(m):
    a, b, c = map(int, input().split())
    edges.append((a, b, c))

dist = [0] * (n + 1)
parent = [-1] * (n + 1)

x = -1  

for i in range(n):
    x = -1
    for u, v, cost in edges:
        if dist[u] + cost < dist[v]:
            dist[v] = dist[u] + cost
            parent[v] = u
            x = v  

if x == -1:
    print("NO")
else:
    for _ in range(n):
        x = parent[x] 

    cycle = []
    cur = x
    while True:
        cycle.append(cur)
        if cur == x and len(cycle) > 1:
            break
        cur = parent[cur]

    cycle.reverse()
    print("YES")
    print(" ".join(map(str, cycle)))