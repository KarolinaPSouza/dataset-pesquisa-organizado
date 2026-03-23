from collections import deque

def bfs(v):
    visited = [0] * (n + 1)
    queue.append((v, 0))

    # (node, height)
    result = (0, 0)

    while queue:
        result = queue.popleft()
        visited[result[0]] = 1

        for c in graph[result[0]]:
            if not visited[c]:
                queue.append((c, result[1] + 1))

    return result



n = int(input())
graph = {}
queue = deque()

if n == 1:
    print(0)
    exit()

global n_vis
nodes_visited = 0

for _ in range(n - 1):
    a, b = map(int, input().split())
    if a not in graph:
        graph[a] = [b]
    else:
        graph[a].append(b)

    if b not in graph:
        graph[b] = [a]
    else:
        graph[b].append(a)

first_search = bfs(1)
second_search = bfs(first_search[0])

print(second_search[1])