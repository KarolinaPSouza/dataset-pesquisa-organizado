from collections import defaultdict
from math import inf
from heapq import heappush, heappop

def dijkstra(src, dest):
    dist = [inf]*(n+1)
    minheap = []
    heappush(minheap, (0, 0, 0, src))
    best_cost = inf
    while minheap:
        cost, distance, max_flight, city = heappop(minheap)
        if city == n:
            best_cost = min(best_cost, cost)
        if distance >= dist[city]: continue
        dist[city] = distance
        for ncity, nw in graph[city]:
            ndistance = distance + nw
            nmax_flight = max(max_flight, (nw+1)//2)
            ncost = ndistance - nmax_flight
            if ncost < dist[ncity]:
                heappush(minheap, (ncost, ndistance, nmax_flight, ncity))
    return best_cost

if __name__ == '__main__':
    n, m = map(int, input().split())
    graph = defaultdict(list)
    for _ in range(m):
        a, b, c = map(int, input().split())
        graph[a].append((b,c))
    print(dijkstra(1, n))