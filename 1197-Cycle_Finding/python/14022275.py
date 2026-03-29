def negtivecycle(n, m, edges):
    dist = [0] * (n + 1)
    parent = [-1] * (n + 1)
    x = -1

    # Bellman-Ford relaxation
    for i in range(n):
        x = -1
        for u, v, w in edges:
            if dist[u] + w < dist[v]:
                dist[v] = dist[u] + w
                parent[v] = u
                x = v

    if x == -1:
        return ("NO", [])

    # Ensure x is in a cycle
    for _ in range(n):
        x = parent[x]

    # Reconstruct cycle
    cycle = []
    cur = x
    visited = set()
    while True:
        if cur in visited:
            break
        visited.add(cur)
        cycle.append(cur)
        cur = parent[cur]

    cycle.append(cur)
    cycle.reverse()

    # Special case: handle self-loop properly
    if len(cycle) >= 2 and cycle[0] == cycle[-1] and len(set(cycle)) == 1:
        return ("YES", [cycle[0], cycle[0]])

    return ("YES", cycle)

# --------- INPUT HANDLING ---------
if __name__ == "__main__":
    import sys
    input = sys.stdin.readline

    n, m = map(int, input().split())
    edges = [tuple(map(int, input().split())) for _ in range(m)]

    result, cycle = negtivecycle(n, m, edges)
    if result == "NO":
        print("NO")
    else:
        print("YES")
        print(' '.join(map(str, cycle)))