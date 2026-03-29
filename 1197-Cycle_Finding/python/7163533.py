from collections import defaultdict

n, m = map(int, input().split())
edges = []
for i in range(m):
    edge = tuple(map(int, input().split()))
    edges.append(edge)

found_cycle = False
for start_node in range(1, n + 1):
    dist = [float("inf")] * (n + 1)
    dist[start_node] = 0
    prev = [-1] * (n + 1)
    last_relaxed_node = -1
    for i in range(n):
        last_relaxed_node = -1
        for start, end, length in edges:
            if dist[start] + length < dist[end]:
                dist[end] = dist[start] + length
                prev[end] = start
                last_relaxed_node = end
        if last_relaxed_node == -1:
            break
    if last_relaxed_node != -1:
        found_cycle = True
        visited = set()
        cycle = []
        node = last_relaxed_node
        while node not in visited:
            visited.add(node)
            cycle.append(node)
            node = prev[node]
        cycle.append(node)
        print("YES")
        print(" ".join(map(str, cycle[::-1])))
        break

if not found_cycle:
    print("NO")