from collections import deque

def bfs(s):
    d = [-1] * (n + 1)
    d[s] = 0
    q = deque([s])

    while q:
        u = q.popleft()
        for v in a[u]:
            if d[v] == -1:
                d[v] = d[u] + 1
                q.append(v)

    return d.index(max(d)), max(d)

n = int(input())
a = [[] for _ in range(n + 1)]

for _ in range(n - 1):
    x, y = map(int, input().split())
    a[x].append(y)
    a[y].append(x)

f1, _ = bfs(1)
f2, res = bfs(f1)

print(res)