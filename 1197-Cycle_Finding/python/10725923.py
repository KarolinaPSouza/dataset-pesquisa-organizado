from heapq import heappush, heappop
def solve():
    n,m = [int(e) for e in input().split(' ')]
    edges = [[int(e) for e in input().split(' ')] for _ in range(m)]

    for node in range(1,n+1):
        edges.append((0,node,0))

    dis = [0]*(n+1)
    relaxant = [-1]*(n+1)
    for _ in range(n):
        start = -1
        for u,v,w in edges:
            if dis[v] > dis[u]+w:
                dis[v] = dis[u]+w
                relaxant[v] = u
                start = v

    if start == -1:
        print("NO")
        return

    for _ in range(n):
        start = relaxant[start]

    cycle = [start]
    node = start
    while relaxant[node] != start:
        node = relaxant[node]
        cycle.append(node)
    cycle.append(start)

    cycle.reverse()
    print("YES")
    print(' '.join([str(e) for e in cycle]))
    return

t=1
while t != 0:
    t -= 1
    solve()