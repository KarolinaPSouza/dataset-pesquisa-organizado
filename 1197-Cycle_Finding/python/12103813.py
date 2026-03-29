import sys

def find_negative_cycle(n, edges):
    INF = 10**18
    distance = [INF] * (n + 1)
    parent = [-1] * (n + 1)
    distance[0] = 0

    last_relaxed_node = -1
    for i in range(n + 1):
        last_relaxed_node = -1
        for a, b, c in edges:
            if distance[a] != INF and distance[b] > distance[a] + c:
                distance[b] = distance[a] + c
                parent[b] = a
                last_relaxed_node = b

                if i == n:
                    u = last_relaxed_node
                    for _ in range(n):
                        u = parent[u]

                    cycle = []
                    current = parent[u]
                    cycle.append(u)
                    while current != u:
                        cycle.append(current)
                        current = parent[current]
                    cycle.append(u)
                    cycle.reverse()

                    print("YES")
                    print(" ".join(map(str, cycle)))
                    return

        if last_relaxed_node == -1:
            break

    print("NO")

n, m = map(int, sys.stdin.readline().split())
edges = []
for _ in range(m):
    a, b, c = map(int, sys.stdin.readline().split())
    edges.append((a, b, c))

for i in range(1, n + 1):
    edges.append((0, i, 0))

find_negative_cycle(n, edges)
