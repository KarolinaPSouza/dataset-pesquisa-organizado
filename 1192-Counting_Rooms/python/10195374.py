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

n, m = list(map(int, input().split()))
g = []
for i in range(n):
    g.append(list(input()))
isvalid = lambda i, j: 0 <= i < n and 0 <= j < m and g[i][j] == "."


def flood(i, j):
    q = deque([(i, j)])
    while q:
        i, j = q.popleft()
        if isvalid(i, j):
            g[i][j] = "#"
            q.extend([(i+1, j), (i, j+1), (i-1, j), (i, j-1)])

res = 0
for i in range(n):
    for j in range(m):
        if isvalid(i, j):
            flood(i, j)
            res += 1
print(res)