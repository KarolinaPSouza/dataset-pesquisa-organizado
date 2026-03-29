def read(f=int):
    return f(input())


def read_list(f=int):
    return list(map(f, input().split()))


MOD = int(1e9) + 7


def bellman_ford_negative(edges, n):
    dist = [0 for _ in range(n)]
    parent = [-1 for _ in range(n)]

    for e in edges:
        u, v, w = e
        if u == v and w < 0:
            return [u, v]

    for _ in range(n - 1):
        for e in edges:
            u, v, w = e
            if dist[u] + w < dist[v]:
                dist[v] = dist[u] + w
                parent[v] = u

    for e in edges:
        u, v, w = e
        if dist[u] + w < dist[v]:
            visited = [False] * n
            path = []
            source = v
            while not visited[source]:
                visited[source] = True
                path.append(source)
                source = parent[source]
            path.append(source)
            return reversed(path[path.index(source):])
    return None


def solve():
    n, m = tuple(read_list())
    edges = []
    for _ in range(m):
        u, v, w = tuple(read_list())
        u -= 1
        v -= 1
        edges.append((u, v, w))

    cycle = bellman_ford_negative(edges, n)
    if cycle:
        print("YES")
        print(*[v + 1 for v in cycle])
    else:
        print("NO")


if __name__ == "__main__":
    T = 1
    # T = int(input())
    for _ in range(T):
        solve()