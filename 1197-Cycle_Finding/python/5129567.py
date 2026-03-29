from sys import stdin
input = stdin.buffer.readline
INF = 1<<59

n, m = map(int, input().split())
dist = [INF] * (n + 1)
prec = [-1] * (n + 1)
edges = []
for _ in range(m):
    a, b, x = map(int, input().split())
    edges.append((a, b, x))

for _ in range(n):
    x = -1
    for u, v, w in edges:

        if dist[u] + w < dist[v]:
            prec[v] = u
            dist[v] = dist[u] + w
            x = v

if x == -1:
    print("NO")
else:
    print("YES")
    for _ in range(n):
        x = prec[x]

    end = x
    path = [x]
    x = prec[x]
    while x != end:
        path.append(x)
        x = prec[x]
    path.append(end)
    path.reverse()
    print(*path)