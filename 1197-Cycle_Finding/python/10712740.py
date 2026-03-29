def find_negative_cycle(n, edges):
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
                    return cycle[::-1]
        if not relaxed:
            break
    return None

def sol():
    n, m = map(int, input().strip().split())
    edges = [list(map(int, input().strip().split())) for _ in range(m)]

    for u, v, w in edges:
        if u == v and w < 0:
            print("YES")
            print(u, u)
            return

    cycle = find_negative_cycle(n, edges)

    if cycle:
        print("YES")
        print(*cycle)
    else:
        print("NO")

sol()