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


ip = map(int, stdin.read().split())
rd = ip.__next__
tree = defaultdict(list)
n = rd()
for _ in range(n - 1):
    a, b = rd() - 1, rd() - 1
    tree[a].append(b)
    tree[b].append(a)


def bfs(root):
    que, d = deque([root]), [inf] * (n)
    d[root] = 0
    while que:
        u = que.popleft()
        for v in tree[u]:
            if d[v] > d[u] + 1:
                d[v] = d[u] + 1
                que.append(v)
    return (max(range(n), key=lambda i: d[i]), max(d))


a = 0
b, _ = bfs(a)
print(bfs(b)[1])