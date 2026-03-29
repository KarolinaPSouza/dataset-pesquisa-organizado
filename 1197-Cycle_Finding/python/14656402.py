import sys


n, m = map(int, input().split())
edges = []
for _ in range(m):
    a, b, c = map(int, input().split())
    edges.append((a, b, c))

INF = 10**18
dist = [0] * (n + 1)
parent = [-1] * (n + 1)

x = -1
for i in range(n):
    x = -1
    for u, v, w in edges:
        if dist[v]!=-INF and dist[v] > dist[u] + w:
            dist[v] = dist[u] + w
            parent[v] = u
            x = v

if x == -1:
    print("NO")
else:
    print("YES")
    # move inside the cycle
    for _ in range(n):
        x = parent[x]

    cycle = []
    cur = x
    while True:
        cycle.append(cur)
        cur = parent[cur]
        if cur == x :
            cycle.append(x)

            break
  #  cycle.append(x)
    cycle.reverse()
    print(*cycle)