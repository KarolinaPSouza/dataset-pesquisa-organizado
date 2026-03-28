from collections import deque

n = int(input())
adj = [[] for _ in range(n)]

for _ in range(n-1):
    a, b = map(int, input().split())
    a -= 1; b -= 1
    adj[a].append(b)
    adj[b].append(a)

def performBfs(source):
    queue = deque()
    queue.append((source, 0))
    distance = [None]*n
    distance[source] = 0
    while queue:
        u, level = queue.popleft()
        for v in adj[u]:
            if distance[v] is None:
                distance[v] = level+1
                queue.append((v, level+1))
    return u, distance

v, _ = performBfs(0)
v1, distance1 = performBfs(v)
v2, distance2 = performBfs(v1)
ans = [str(max(x, y)) for x, y in zip(distance1, distance2)]
print(" ".join(ans))