import io, os
# import sys, random
input = io.BytesIO(os.read(0,os.fstat(0).st_size)).readline
# sys.setrecursionlimit(10**9)
# intput = lambda: int(input())
intputs = lambda: map(int, input().split())
# intlist = lambda: list(map(int, input().split()))
# RANDOM = random.randrange(2**62)
# inf = float('inf')


def find_negative_cycles(n, edges):
    dist = [0] * n
    parent = [-1] * n
    x = None

    for _ in range(n):
        x = None
        for u,v,w in edges:
            if dist[v] > dist[u] + w:
                dist[v] = dist[u] + w
                x = v
                parent[v] = u

    if x is None:
        print('NO')
        return
    print('YES')
    vis = [False] * n
    path = []
    while vis[x] is False:
        vis[x] = True
        path.append(x)
        x = parent[x]

    i = path.index(x)
    path.append(x)
    cycle = path[i:][::-1]
    print(*cycle)





n,m = intputs()
edges = [ tuple(intputs()) for _ in range(m) ]
find_negative_cycles(n+1, edges)