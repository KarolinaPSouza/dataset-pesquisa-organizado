import math

def bellman_ford(arr, n):
    dp = [0] * n
    predecessor = [-1] * n

    for i in range(n):
        for u, v, w in arr:
            if dp[u] + w < dp[v]:
                dp[v] = dp[u] + w
                predecessor[v] = u

    return dp, predecessor

def find_cycle(predecessor, start):
    cycle = []
    visited = set()
    while start not in visited:
        visited.add(start)
        start = predecessor[start]

    cycle_start = start
    cycle.append(cycle_start)
    current = predecessor[cycle_start]
    while current != cycle_start:
        cycle.append(current)
        current = predecessor[current]
    cycle.append(cycle_start)

    cycle.reverse()
    return cycle

V, E = map(int, input().split())

graph = []

for _ in range(E):
    u, v, w = map(int, input().split())
    graph.append((u, v, w))

dp, predecessor = bellman_ford(graph, V + 1)
flag = False

for u, v, w in graph:
    if  dp[u] + w < dp[v]:
        print("YES")
        flag = True
        cycle = find_cycle(predecessor, v)
        print(" ".join(map(str, cycle)))
        break

if not flag:
    print("NO")