import sys


def find_negative_cycle(n, edges):
    INF = float('inf')
    dist = [0] * (n + 1)
    parent = [-1] * (n + 1)

    x = -1
    for _ in range(n):
        x = -1
        for a, b, c in edges:
            if dist[a] + c < dist[b]:
                dist[b] = dist[a] + c
                parent[b] = a
                x = b

    if x == -1:
        print("NO")
        return

    # Asegurar que x pertenece realmente al ciclo
    visited = set()
    for _ in range(n):
        x = parent[x]

    cycle = []
    v = x
    while v not in visited:
        visited.add(v)
        cycle.append(v)
        v = parent[v]
    cycle.append(v)
    cycle.reverse()

    print("YES")
    print(" ".join(map(str, cycle)))

# Leer entrada


def main():
    n, m = map(int, sys.stdin.readline().split())
    edges = []
    for _ in range(m):
        a, b, c = map(int, sys.stdin.readline().split())
        edges.append((a, b, c))

    find_negative_cycle(n, edges)


if __name__ == "__main__":
    main()