from collections import deque

def tree_diameter(graph):
    last_node, level = bfs(graph, 0, 1)
    last_node, level = bfs(graph, 0, last_node)
    return level

def bfs(graph, parent, src):
    q = deque([(parent, src)])
    last_node = src
    level = -1
    while q:
        level += 1
        size = len(q)
        for _ in range(size):
            p, i = q.popleft()
            last_node = i

            for j in graph[i]:
                if j == p:
                    continue

                q.append((i, j))

    return last_node, level        

N = int(input())
edges = list()
for _ in range(N - 1):
    edge = [int(x) for x in input().split()]
    edges.append(edge)

graph = {i: set() for i in range(1, N + 1)}
for u, v in edges:
    graph[u].add(v)
    graph[v].add(u)

print(tree_diameter(graph))