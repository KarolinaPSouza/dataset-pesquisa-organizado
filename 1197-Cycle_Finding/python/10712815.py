def sol():
    n, m = map(int, input().strip().split())
    edges = [list(map(int, input().strip().split())) for _ in range(m)]

    for u, v, w in edges:
        if u == v and w < 0:
            print("YES")
            print(u, u)
            return

    dist = [0] * (n + 1)
    parent = [-1] * (n + 1)

    for i in range(n):
        relaxed = False
        for u, v, w in edges:
            if dist[u] + w < dist[v]:
                dist[v] = dist[u] + w
                parent[v] = u
                relaxed = True
                if i == n - 1:
                    visited = [False] * (n + 1)
                    while not visited[v]:
                        visited[v] = True
                        v = parent[v]
                    cycle = [v]
                    u = parent[v]
                    while u != v:
                        cycle.append(u)
                        u = parent[u]
                    cycle.append(v)
                    print("YES")
                    print(*cycle[::-1])
                    return
        if not relaxed:
            break

    print("NO")

sol()