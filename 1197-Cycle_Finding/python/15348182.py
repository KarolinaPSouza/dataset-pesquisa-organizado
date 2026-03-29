import sys


def solve():
    input = sys.stdin.readline
    n, m = map(int, input().split())

    edges = []
    adjl = {i:[] for i in range(1, n+1)}
    for _ in range(m):
        n1, n2, weight = map(int, input().split())
        edges.append((n1, n2, weight))
        adjl[n1].append((n2, weight))

    dist = [0] * (n+1)
    relaxant = {i:-1 for i in range(1, n+1)}

    for i in range(n):
        x = -1
        for u, v, w in edges:
            if (dist[u] + w < dist[v]):
                dist[v] = dist[u] + w
                relaxant[v] = u
                x = u

    if x == -1:
        print("NO")
        return 

    for i in range(n):
        x = relaxant[x]

    cycle = [x]

    curr = x
    while True:
        curr = relaxant[curr]
        cycle.append(curr)
        if (curr == x):
            break

    print("YES")
    print(*cycle[::-1])

solve()