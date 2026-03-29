from heapq import heappush, heappop

MX = 1 << 62

def dijkstra(start, graph, n):
    ds = [MX] * n
    ds[start] = 0
    hq = [(0, start)]

    while hq:
        dist, node = heappop(hq)
        if dist != ds[node]:     # skip stale entry
            continue
        for nr, w in graph[node]:
            nd = dist + w
            if nd < ds[nr]:
                ds[nr] = nd
                heappush(hq, (nd, nr))

    return ds


def main():
    import sys
    input = sys.stdin.readline

    n, m = map(int, input().split())
    graph = [[] for _ in range(n)]
    rg = [[] for _ in range(n)]

    for _ in range(m):
        a, b, c = map(int, input().split())
        a -= 1; b -= 1
        graph[a].append((b, c))
        rg[b].append((a, c))

    ds  = dijkstra(0,    graph, n)
    ds2 = dijkstra(n - 1, rg,   n)

    ans = MX
    for a in range(n):
        da = ds[a]
        if da == MX:
            continue
        for b, c in graph[a]:
            d2 = ds2[b]
            if d2 < MX:
                v = da + (c >> 1) + d2
                if v < ans:
                    ans = v

    print(ans)


if __name__ == "__main__":
    main()