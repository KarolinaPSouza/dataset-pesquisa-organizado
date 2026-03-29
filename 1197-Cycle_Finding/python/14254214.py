n, m = map(int, input().split())
edges = []
for _ in range(m):
    u, v, w = map(int, input().split())
    edges.append((u, v, w))
dist = [0] * (n+1)
parent = [-1] * (n+1)

c_node = -1
for i in range(n):
    for u, v, w in edges:
        if dist[u] + w < dist[v]:
            dist[v] = dist[u] + w
            parent[v] = u
            if i == n - 1:  
                c_node = v

if c_node == -1:
    print("NO")
else:
    print("YES")

    for _ in range(n):
        c_node = parent[c_node]
    cycle_path = []

    temp_node = c_node
    while True:
        cycle_path.append(temp_node)
        temp_node = parent[temp_node]
        if temp_node == c_node:
            cycle_path.append(temp_node) 
            break
    cycle_path.reverse()

    print(*cycle_path)