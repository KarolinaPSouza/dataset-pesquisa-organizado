n = int(input())

edges = {i: [] for i in range(1,n+1)}

for i in range(1,n):
    a,b = map(int, input().split())
    edges[a].append(b)
    edges[b].append(a)

start = 1

from collections import deque

def bfs(start):
    global edges
    visited = [False for i in range(n+1)]
    visited[start] = True
    q = deque([(start,0)])
    while q:
        node,distance = q.popleft()
        for i in edges[node]:
            if not visited[i]:
                visited[i] = True
                q.append((i,distance+1))
    return node,distance

node,distance = bfs(start)
node,distance = bfs(node)

print(distance)