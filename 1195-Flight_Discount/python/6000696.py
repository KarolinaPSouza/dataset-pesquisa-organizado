import heapq
from types import *
from typing import *
from collections import defaultdict

inf, mod = int(1e18), 998244353
N, M = int(2e5), int(1e6)


def d(a: List[List[int]], src: int, n: int) -> List[int]:
    pq = []
    heapq.heappush(pq, (0, src))

    res = [inf for _ in range(n + 1)]
    res[src] = 0

    while pq:
        w, fr = heapq.heappop(pq)
        if res[fr] != w:
            continue
        for w2, to in a[fr]:
            if w + w2 < res[to]:
                res[to] = w + w2
                heapq.heappush(pq, (w + w2, to))

    return res


def solve():
    n, m = map(int, input().split())

    a, b = [[] for _ in range(n + 1)], [[] for _ in range(n + 1)]
    for i in range(m):
        u, v, w = map(int, input().split())
        a[u].append((w, v))
        b[v].append((w, u))

    left, right = d(a, 1, n), d(b, n, n)

    res = inf
    for fr in range(1, n + 1):
        for w, to in a[fr]:
            res = min(res, left[fr] + w // 2 + right[to])

    print(res)


def main():
    t = 1
    # t = int(input())
    for _ in range(t):
        solve()


main()