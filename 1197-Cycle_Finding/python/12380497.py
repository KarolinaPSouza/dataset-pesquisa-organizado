n, m = map(int, input().split())
edges = []

for _ in range(m):
    u, v, d = map(int, input().split())
    edges.append((u-1, v-1, d))

distance = [10**18 for i in range(n)]
parent = [None]*n
distance[0] = 0
last = None
for i in range(n):
    last = None
    for u, v, d in edges:
        if distance[v] > distance[u] + d:
            distance[v] = distance[u] + d
            parent[v] = u
            last = v

if last is None:
    print('NO')
    exit()

for i in range(n):
    last = parent[last]

print('YES')
ans = []
x = last
while True:
    ans.append(str(x+1))
    if x == last and len(ans) > 1:
        break
    x = parent[x]
ans.reverse()
print(" ".join(ans))