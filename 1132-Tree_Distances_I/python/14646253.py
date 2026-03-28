n = int(input())
adj = [[] for _ in range(n)]
for _ in range(n-1):
    u,v = map(int,input().split(" "))
    u -= 1
    v -= 1
    adj[u].append(v)
    adj[v].append(u)

dist1 = [0]*n
vis = [0]*n
stack = [(0,0)]
while stack:
    u,d = stack.pop()
    if vis[u]:
        continue
    vis[u] = 1
    dist1[u] = d
    for v in adj[u]:
        stack.append((v,d+1))
d1 = max(range(n),key=lambda x: dist1[x])
dist2 = [0]*n
vis = [0]*n

stack = [(d1,0)]

while stack:
    u,d,= stack.pop()
    if vis[u]:
        continue
    vis[u] = 1
    dist2[u] = d
    for v in adj[u]:
        stack.append((v,d+1))
d2 = max(range(n),key=lambda x: dist2[x])

dist1 = [0]*n
vis = [0]*n
stack = [(d1,0)]
while stack:
    u,d = stack.pop()
    if vis[u]:
        continue
    vis[u] = 1
    dist1[u] = d
    for v in adj[u]:
        stack.append((v,d+1))

dist2 = [0]*n
vis = [0]*n
stack = [(d2,0)]

while stack:
    u,d,= stack.pop()
    if vis[u]:
        continue
    vis[u] = 1
    dist2[u] = d
    for v in adj[u]:
        stack.append((v,d+1))




ans = [0]*n
for i in range(n):
    ans[i] = max(dist1[i],dist2[i])
print(*ans)