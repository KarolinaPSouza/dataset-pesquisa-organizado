import sys

def main():
    input = sys.stdin.readline
    n, m = map(int, input().split())
    edges = []
    for _ in range(m):
        u, v, w = map(int, input().split())
        edges.append((u, v, w))

    # Initialize distances to 0 so we detect negative cycles anywhere
    dist = [0] * (n + 1)
    parent = [-1] * (n + 1)

    x = -1  # will hold a vertex that got relaxed in nth iteration
    for _ in range(n):
        x = -1
        for u, v, w in edges:
            if dist[u] + w < dist[v]:
                dist[v] = dist[u] + w
                parent[v] = u
                x = v

    if x == -1:
        print("NO")
        return

    # There is a negative cycle. Find a node y guaranteed to be on the cycle.
    y = x
    for _ in range(n):
        y = parent[y]

    # Reconstruct the cycle by following parent[] until we return to y
    cycle = []
    cur = y
    while True:
        cycle.append(cur)
        cur = parent[cur]
        if cur == y:
            cycle.append(y)
            break

    # Reverse to print in forward order (start -> ... -> start)
    cycle.reverse()
    print("YES")
    print(*cycle)

if __name__ == "__main__":
    main()