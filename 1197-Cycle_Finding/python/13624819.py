n, m = map(int, input().split())
edges = []
for _ in range(m):
    x = input().split()
    a = int(x[0])
    b = int(x[1])
    c = int(x[2])
    edges.append((a, b, c))

d = [10**18] * (n + 1)
parent = [-1] * (n + 1)
d[0] = 0  


for i in range(1, n+1):
    edges.append((0, i, 0))

# Bellman-Ford global
x = -1
for i in range(n+1):
    x = -1
    for (a, b, c) in edges:
        if d[a] + c < d[b]:
            d[b] = d[a] + c
            parent[b] = a
            x = b

if x == -1:
    print("NO")
else:
    print("YES")
    # reconstruir ciclo
    for _ in range(n+1):
        x = parent[x]
    ciclo = []
    v = x
    while True:
        ciclo.append(v)
        if v == x and len(ciclo) > 1:
            break
        v = parent[v]
    ciclo.reverse()
    print(" ".join(str(xx) for xx in ciclo if xx != 0))