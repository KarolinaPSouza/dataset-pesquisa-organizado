import heapq
import sys

def solve():
    stuff = map(int, sys.stdin.read().split())

    n,m = next(stuff), next(stuff)

    f = [[] for i in range(n)]

    for i in range(m):
        a,b,c = next(stuff), next(stuff), next(stuff)
        f[a-1].append((c, b-1))


    dist = [[0,0]] + [[10**14, 10**14] for i in range(n-1)] #without coupon, with coupon
    h = [(0,0,0)]

    while h:
        d, v, coupon = heapq.heappop(h)
        if d <= dist[v][coupon]:
            for cost, nbr in f[v]:
                x = dist[nbr]
                if x[coupon] > d+cost:
                    x[coupon] = d+cost
                    heapq.heappush(h, (d+cost, nbr, coupon))
                if not coupon:
                    if x[1] > d+cost//2:
                        x[1] = d+cost//2
                        heapq.heappush(h,(d+cost//2,nbr,1))

    print(dist[-1][-1])

solve()
