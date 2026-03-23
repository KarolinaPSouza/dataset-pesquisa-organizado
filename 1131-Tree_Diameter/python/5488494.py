import collections
inf = float('inf')
n = int(input())
g = collections.defaultdict(set)
for _ in range(n-1):
    u, v = map(int, input().split())
    g[u].add(v)
    g[v].add(u)

d = [inf] * (n + 1)

def bfs(source : int):
    for u in range(n + 1):
        d[u] = inf
    d[source] = 0
    q = collections.deque([source])
    while q:
        u = q.popleft()
        for v in g[u]:
            if d[v] == inf:
                d[v] = d[u] + 1
                q.append(v)
bfs(1)
start = 1
for u in range(1, n + 1):
    if d[u] > d[start]:
        start = u

bfs(start)
end = start
for u in range(1, n + 1):
    if d[u] > d[end]:
        end = u
#print(d, start, end)
print(d[end] - d[start])