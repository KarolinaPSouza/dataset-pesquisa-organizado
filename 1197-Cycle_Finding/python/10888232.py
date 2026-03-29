INF = 10**18

def bellman_ford(soure: int):
    dist[soure] = 0
    last_node_update = 0
    for i in range(1, n + 1):
        last_node_update = -1
        for (u, v, w) in graph:
            if dist[u] + w < dist[v]:
                dist[v] = dist[u] + w
                parent[v] = u
                last_node_update = v

    if last_node_update == -1:
        print("NO")
        exit()
    else:
        print("YES")
        cycle = []
        for i in range(1, n - 1):
            last_node_update = parent[last_node_update]

        x = last_node_update
        while True:
            cycle.append(x)
            if x == last_node_update and len(cycle) > 1:
                break
            x = parent[x]

        cycle.reverse()
        print(*cycle)


n, m = map(int, input().split())

graph = []
parent = [0] * (n + 1)
dist = [INF] * (n + 1)

for _ in range(m):
    u, v, w = map(int, input().split())
    graph.append((u, v, w))

bellman_ford(1)