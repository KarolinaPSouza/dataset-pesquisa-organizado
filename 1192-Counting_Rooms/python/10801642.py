# Author : Abenezer Mulugeta Woldesenbet @abeni505

import sys , heapq , threading
from heapq import heappush, heappop, heapify, heappushpop
from collections import Counter , defaultdict , deque
from itertools import permutations , combinations ,accumulate
from random import randint, randrange
from math import gcd, floor, sqrt, log, ceil
from bisect import bisect_left, bisect_right, insort_left, insort_right
from functools import lru_cache 
input = sys.stdin.readline
def st(): return input().strip()
def I(): return int(input().strip())
def ints(): return map(int, input().strip().split())
def lst(): return list(map(int, input().strip().split()))


def solve():
    n , m = ints()

    mat = []
    for r in range(n):
        mat.append(st())

    def inbound(row , col):
        return 0 <= row < n and 0 <= col < m

    drxn = [(-1, 0),(1, 0), (0, 1), (0, -1)]

    visited = [[False] * m for _ in range(n)]

    def dfs(r , c):
        stack = [(r , c)]
        while stack:
            r , c = stack.pop()
            for x , y in drxn:
                new_r = r + x
                new_c = c + y

                if inbound(new_r, new_c) and not visited[new_r][new_c] and mat[new_r][new_c] == ".":
                    visited[new_r][new_c] = True
                    stack.append((new_r, new_c))

    count = 0
    for r in range(n):
        for c in range(m):
            if mat[r][c] == "." and not visited[r][c]:
                visited[r][c] = True
                dfs(r, c)
                count += 1

    print(count)




if __name__ == "__main__":
    t = 1 or I()
    for _ in range(t):solve()




# Copyright © 2024 Abenezer Mulugeta Woldesenbet.All rights reserved.