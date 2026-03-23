from collections import deque

n = int(input())
g = [[] for _ in range(n)]

for _ in range(n - 1):
    a, b = map(int, input().split())
    a -= 1
    b -= 1
    g[a].append(b)
    g[b].append(a)

def bfs(start, g):
    q = deque([start])
    dis = [-1] * n
    dis[start] = 0
    mx = start
    while q:
        v = q.popleft()
        for next in g[v]:
            if dis[next] == -1:
                dis[next] = dis[v] + 1
                if dis[mx] < dis[next]:
                    mx = next
                q.append(next)

    return dis, mx

_, a = bfs(0, g)
dis, b = bfs(a, g)

print(dis[b])

