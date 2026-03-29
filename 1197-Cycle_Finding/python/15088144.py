n, m = list(map(int, input().split()))
edges = []
for i in range(m):
    u, v, w = list(map(int, input().split()))
    edges.append((u, v, w))
for i in range(1, n+1):
    edges.append((0, i, 0))
dist = [(10**18, None) for i in range(n+1)]
dist[0] = (0, None)
# edges.sort(reverse = True, key = lambda el: el[-1])
for vi in range(n+1):
    changed = False
    for e in edges:
        u, v, w = e
        if dist[u][0] != 10**18 and vi < n and dist[u][0] + w < dist[v][0]:
            dist[v] = (dist[u][0] + w, u)
            changed = True
        elif abs(dist[u][0]) != 10**18 and vi >= n and dist[u][0] + w < dist[v][0]:
            dist[v] = (-10**18, u)
            changed = True
        # print(dist)
    if not changed:
        break


path = []
curr = 1
orig = None
indices = [-1 for i in range(n+1)]
for i in range(1, n+1):
    if dist[i][0] == -10**18:
        curr = i
        orig = i
        while True:
            # print(curr)
            indices[curr] = len(path)
            path.append(curr)
            curr = dist[curr][1]
            if indices[curr] != -1:
                path.append(curr)
                break
            # print(path)
        path = path[indices[curr]:]
        print("YES")
        print(" ".join(str(i) for i in path[::-1]))
        break
else:
    print("NO")