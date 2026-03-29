from  collections import defaultdict ,deque
import heapq
import sys
import math
import itertools 
#from bisect import bisect_left, bisect_right, insort_left, insort_right
import os

input = lambda: sys.stdin.readline().strip()
from heapq import heappop, heappush


def dijkstra(graph, start,n):
    """ 
        Uses Dijkstra's algortihm to find the shortest path from node start
        to all other nodes in a directed weighted graph.
    """
    # n = len(graph)
    dist, parents = [float("inf")] * n, [-1] * n
    dist[start] = 0

    queue = [(0, start)]
    while queue:
        path_len, v = heappop(queue)
        if path_len == dist[v]:
            for w, edge_len in graph[v]:
                if edge_len + path_len < dist[w]:
                    dist[w], parents[w] = edge_len + path_len, v
                    heappush(queue, (edge_len + path_len, w))

    return dist

def solve():
    n,m=[int(i) for i in input().split()]
    d=defaultdict(list)
    rd=defaultdict(list)
    for _ in range(m):
        a,b,c=[int(i) for i in input().split()]
        d[a].append((b,c))
        rd[b].append((a,c))
    l1=dijkstra(d,1,n+1)
    ln=dijkstra(rd,n,n+1)
    totalmin=float('inf')
    for u in d:
        for v,w in d[u]:

            totalmin=min(totalmin,l1[u]+ln[v]+w//2)
    print(totalmin)


if __name__ == "__main__":
    # for i in range(int(input())):
        solve()