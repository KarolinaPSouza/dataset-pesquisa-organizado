def solve():

    n, m = inp()
    adj = [[] for _ in range(n + 1)]
    distmx = [float('inf')] * (n + 1)
    distmx[1] = 0
    dist = distmx[:]
    for _ in range(m):
        a, b, c = inp()
        adj[a].append((b, c))

    pq = [(0, 0, 1)]

    while pq:
        cmx, c, city = heappop(pq)

        if cmx > distmx[city] and c > dist[city]:

            continue

        for node, price in adj[city]:
            nmx = min(c + price // 2, cmx + price)
            ncost = c + price
            if nmx < distmx[node] or ncost < dist[node]:
                heappush(pq, (nmx, ncost, node))
                dist[node] = min(ncost, dist[node])
                distmx[node] = min(nmx, distmx[node])


    return distmx[-1]




def main():

    T = 1

    for _ in range(T):
        x = solve()

        if x is not None:
            print(x)


from sys import stdin, stdout
from bisect import bisect, bisect_right
from collections import Counter, defaultdict, deque
from heapq import heappush, heappop
from itertools import accumulate
from functools import lru_cache
from math import ceil, comb, factorial, gcd, isqrt, sqrt


input = lambda : stdin.readline().rstrip('\r\n')
inp = lambda dtype=int : list(map(dtype, input().split()))
flush = stdout.flush
convert = lambda data, sep='\n' : sep.join(map(str, data))

main()






