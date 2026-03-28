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

M = 10**9 + 7
SALT = randint(1, 10**9)

n = int(input())
g = defaultdict(list)
for _ in range(n - 1):
    u, v = list(map(int, input().split()))
    g[u].append(v)
    g[v].append(u)


def bfs(u):
    d = [-1] * (n + 1)
    d[u] = 0
    que = deque([(u, 0)])
    while que:
        node, di = que.popleft()
        for v in g[node]:
            if d[v] == -1:
                d[v] = di + 1
                que.append((v, d[v]))
    ans, ad = -1, -1
    for i in range(1, n + 1):
        if d[i] > ad:
            ans = i
            ad = d[i]
    return (ans, ad, d)


a = 1
b, bdist, _ = bfs(a)
c, cdist, d1 = bfs(b)
_, _, d2 = bfs(c)
# print(b, c)
for i in range(1, n + 1):
    print(max(d1[i], d2[i]), end=" ")