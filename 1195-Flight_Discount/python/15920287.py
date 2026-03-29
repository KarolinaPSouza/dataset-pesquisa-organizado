import sys, heapq

def solve():
    data = sys.stdin.buffer.read().split()
    it = iter(data)
    n = int(next(it)); m = int(next(it))

    g = [[] for _ in range(n+1)]
    for _ in range(m):
        a = int(next(it)); b = int(next(it)); c = int(next(it))
        g[a].append((b, c))

    INF = 10**30
    dist0 = [INF]*(n+1)
    dist1 = [INF]*(n+1)

    dist0[1] = 0
    h = [(0, 1, 0)]

    push = heapq.heappush
    pop = heapq.heappop

    while h:
        d, u, used = pop(h)

        if used:
            if d != dist1[u]:
                continue
        else:
            if d != dist0[u]:
                continue

        for v, c in g[u]:
            nd = d + c

            if used == 0:
                if nd < dist0[v]:
                    dist0[v] = nd
                    push(h, (nd, v, 0))

                nd2 = d + (c >> 1)
                if nd2 < dist1[v]:
                    dist1[v] = nd2
                    push(h, (nd2, v, 1))
            else:
                if nd < dist1[v]:
                    dist1[v] = nd
                    push(h, (nd, v, 1))

    res = dist0[n]
    if dist1[n] < res:
        res = dist1[n]
    sys.stdout.write(str(res))

solve()