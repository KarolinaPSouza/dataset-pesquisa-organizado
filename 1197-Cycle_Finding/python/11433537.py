n,m = map(int, input().split())
edges = []
for _ in range(m):
    edges.append(tuple(map(int, input().split())))



dist = [0] * (n + 1)
p = [-1] * (n + 1)

def ford_bellman():
    num_iter = 0
    flag = True
    while flag and num_iter != n + 2:
        flag = False
        for u, v, w in edges:
            if dist[v] > dist[u] + w:
                dist[v] = dist[u] + w
                p[v] = u
                flag = True
        num_iter += 1
    flag = False
    start = None
    for u, v, w in edges:
        if dist[v] > dist[u] + w:
            start = v
            flag = True
            break
    if not flag:
        return []
    for _ in range(n - 1):
        start = p[start]
    cycle = [start]
    curr = p[start]
    while curr != start:
        cycle.append(curr)
        curr = p[curr]
    cycle.append(start)
    cycle.reverse()
    return cycle


res = ford_bellman()
if res:
    print('YES')
    print(*res)
else:
    print('NO')






