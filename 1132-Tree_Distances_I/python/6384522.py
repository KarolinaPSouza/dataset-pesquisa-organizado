from collections import deque

n = int(input())

edges = [[] for _ in range(n + 1)]

for _ in range(n - 1):
    a, b = map(int, input().split())
    edges[a].append(b)
    edges[b].append(a)

endPoint1 = 0
visited = [False] * (n + 1)
maxDistance = 0

stack = deque()
stack.append((1, 0))  # (node, distance)

while stack:
    curr, dist = stack.pop()
    if visited[curr]:
        continue
    visited[curr] = True

    if dist > maxDistance:
        maxDistance = dist
        endPoint1 = curr

    for child in edges[curr]:
        stack.append((child, dist + 1))

maxDistance = 0
endPoint2 = 0

visited = [False] * (n + 1)
maxDistances = [0] * n

stack.append((endPoint1, 0))

while stack:
    curr, dist = stack.pop()
    if visited[curr]:
        continue
    visited[curr] = True

    if dist > maxDistance:
        maxDistance = dist
        endPoint2 = curr

    maxDistances[curr - 1] = max(maxDistances[curr - 1], dist)

    for child in edges[curr]:
        stack.append((child, dist + 1))

visited = [False] * (n + 1)
stack.append((endPoint2, 0))

while stack:
    curr, dist = stack.pop()
    if visited[curr]:
        continue
    visited[curr] = True

    maxDistances[curr - 1] = max(maxDistances[curr - 1], dist)

    for child in edges[curr]:
        stack.append((child, dist + 1))

print(*maxDistances)