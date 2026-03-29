from collections import defaultdict
from heapq import heappop, heappush
import sys
input = sys.stdin.readline
inf = 10 ** 15

def dijkstra(s, d, f):
    d[s] = 0
    q = [(0, s)]
    while q:
        cur, v = heappop(q)
        if cur <= d[v]:
            for u, w in f[v].items():
                dis = cur + w
                if dis < d[u]:
                    d[u] = dis
                    heappush(q, (dis, u))
    return d

def main():
    n, m = map(int, input().split())
    df = {x: inf for x in range(1, n + 1)}
    db = {x: inf for x in range(1, n + 1)}
    g = defaultdict(dict)
    h = defaultdict(dict)
    for _ in range(m):
        a, b, c = map(int, input().split())
        if g[a].get(b, inf) > c:
            g[a][b] = c
            h[b][a] = c
    dijkstra(1, df, g)
    dijkstra(n, db, h)
    ans = inf
    for i, e in g.items():
        for j in e:
            res = e[j] // 2
            res += df[i] + db[j]
            ans = min(ans, res)
    print(ans)

if __name__ == '__main__':
    main()