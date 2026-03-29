import sys

def find_negative_cycle(n, edges):
    INF = float('inf')
    dist = [0] * (n + 1)
    parent = [-1] * (n + 1)
    cycle_start = -1

    for i in range(n):
        cycle_start = -1
        for a, b, c in edges:
            if dist[b] > dist[a] + c:
                dist[b] = dist[a] + c
                parent[b] = a
                cycle_start = b

    if cycle_start == -1:
        print("NO")
    else:
        for _ in range(n):
            cycle_start = parent[cycle_start]

        cycle = []
        v = cycle_start
        while True:
            cycle.append(v)
            if v == cycle_start and len(cycle) > 1:
                break
            v = parent[v]

        cycle.reverse()
        print("YES")
        print(" ".join(map(str, cycle)))

if __name__ == "__main__":
    n, m = map(int, sys.stdin.readline().split())
    edges = []
    for _ in range(m):
        a, b, c = map(int, sys.stdin.readline().split())
        edges.append((a, b, c))

    find_negative_cycle(n, edges)