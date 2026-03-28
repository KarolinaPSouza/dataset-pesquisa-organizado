#sol Shelvi
from collections import deque
def bfs(v):
    result = 0
    distance = [-1] * (n + 1)
    distance[v] = 0
    final[v] = max(final[v], distance[v])
    queue . append (v)
    while queue:
        result = queue.popleft()
        for c in graph[result]:
            if distance[c] == -1:
                queue.append (c)
                distance[c] = distance[result] + 1
                final[c] = max(final[c], distance[c])
    return result
n = int(input())
queue = deque ()
final = [0] * (n + 1)
graph = {}
if n==1:
    print(0)    
    exit()
for _ in range(n - 1):
    a, b = map(int, input().split())
    if a not in graph:
        graph[a] = [b]
    else:
        graph[a].append(b)
    if b not in graph:
        graph[b] = [a]
    else:
        graph[b] .append(a)

first_search = bfs(1)
second_search = bfs(first_search)
bfs(second_search)
out = ' '.join(map(str, final[1:]))
print(out)