from typing import List
from bisect import *
from collections import *
from itertools import *
from math import *
from functools import *
from string import *
from heapq import *
from random import randint
from types import *
from sys import *

setrecursionlimit(100000)
inp = map(int, stdin.read().split())

g = defaultdict(list)
n, m = inp.__next__(), inp.__next__()
for _ in range(m):
    u = inp.__next__()
    v = inp.__next__()
    w = inp.__next__()
    g[u].append((v, w))

q, d = [(0, 1)], [[inf, inf] for _ in range(n + 1)]
d[1][0] = d[1][1] = 0

while q:
    de, u = heappop(q)
    i, u, t = (u < 0), abs(u), u // abs(u)
    if d[u][i] < de:
        continue
    if u == n:
        if i:
            break
        continue
    for v, w in g[u]:
        if d[v][i] > de + w:
            d[v][i] = de + w
            heappush(q, (d[v][i], v * t))
        if not i and d[v][1] > de + (w >> 1):
            d[v][1] = de + (w >> 1)
            heappush(q, (d[v][1], -v))
print(d[n][1])