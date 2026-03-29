n, m = map(int, input().split())
edges = []
for _ in range(m):
    u, v, w = map(int, input().split())
    edges.append((u - 1, v - 1, w))
dist = [0] * n
parent = [-1] * n

last_relaxed_node = -1
for i in range(n):
    for u, v, w in edges:
        if dist[u] + w < dist[v]:
            dist[v] = dist[u] + w
            parent[v] = u
            if i == n - 1:  
                last_relaxed_node = v

if last_relaxed_node == -1:
    print("NO")
else:
    print("YES")

    for _ in range(n):
        last_relaxed_node = parent[last_relaxed_node]
    cycle_path = []

    temp_node = last_relaxed_node
    while True:
        cycle_path.append(temp_node)
        temp_node = parent[temp_node]
        if temp_node == last_relaxed_node:
            cycle_path.append(temp_node) 
            break
    cycle_path.reverse()

    print(*(node + 1 for node in cycle_path))