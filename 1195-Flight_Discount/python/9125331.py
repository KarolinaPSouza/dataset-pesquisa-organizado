# Author: S Mahesh Raju
# Username: maheshraju2020
# Date: 27-04-2024 16:38
from random import randint
from sys import stdin, stdout, setrecursionlimit
# from math import gcd, ceil, sqrt, lcm, comb
from collections import Counter, deque, defaultdict
from bisect import bisect_left, bisect_right
from heapq import heappush, heappop, heapify
from types import GeneratorType
def ii1(): return int(stdin.readline().strip())
def is1(): return stdin.readline().strip()
def iia(): return list(map(int, stdin.readline().strip().split()))
def isa(): return stdin.readline().strip().split()


class Node:
    def __init__(self, distance, name, coupon):
        self.name = name
        self.distance = distance
        self.coupon = coupon

    def __lt__(self, other):
        return self.distance < other.distance


def djikstra():
    heap = []
    heappush(heap, Node(0, 1, 1))
    dist_wc = [float("inf")]*(n+1)
    dist_c = [float("inf")]*(n+1)
    dist_wc[1] = 0
    dist_c[1] = 0
    while heap:
        node = heappop(heap)
        if node.coupon and dist_wc[node.name] < node.distance:
            continue
        if not node.coupon and dist_c[node.name] < node.distance:
            continue
        for neigh, cost in d.get(node.name, []):
            if node.coupon:
                if dist_wc[node.name] + cost//2 < dist_c[neigh]:
                    dist_c[neigh] = dist_wc[node.name] + cost//2
                    heappush(heap, Node(dist_c[neigh], neigh, 0))
                if dist_wc[node.name] + cost < dist_wc[neigh]:
                    dist_wc[neigh] = dist_wc[node.name] + cost
                    heappush(heap, Node(dist_wc[neigh], neigh, 1))
            else:
                if dist_c[node.name] + cost < dist_c[neigh]:
                    dist_c[neigh] = dist_c[node.name] + cost
                    heappush(heap, Node(dist_c[neigh], neigh, 0))
    return min(dist_c[n], dist_wc[n])


n, m = iia()
d = {}
for i in range(m):
    a, b, c = iia()
    d.setdefault(a, []).append([b, c])
print(djikstra())