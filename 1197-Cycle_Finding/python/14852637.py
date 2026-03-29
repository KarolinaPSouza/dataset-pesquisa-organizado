n , m = map(int, input().split())
edges = []
for _ in range(m):
    edges.append(list(map(int, input().split())))
dist = [0] * n
relaxant = [-1] * n
x = -1
for i in range(n):
    x = -1
    for u, v, w in edges:
        if dist[u - 1] + w < dist[v - 1]:
            dist[v - 1] = dist[u - 1] + w
            relaxant[v - 1] = u - 1
            x = v - 1
if x == -1:
    print("NO")
    exit()
for _ in range(n):
    x = relaxant[x]
path = []
cur = x
while True:
    path.append(cur + 1)
    if cur == x and len(path) > 1:
        break
    cur = relaxant[cur]
path.reverse()
print("YES")
print(*path)
