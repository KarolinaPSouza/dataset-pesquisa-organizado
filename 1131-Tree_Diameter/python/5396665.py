from collections import deque, defaultdict, Counter, OrderedDict
from math import ceil, sqrt, hypot, factorial, pi, sin, cos, radians
from heapq import heappush, heappop, heapify, nlargest, nsmallest

import os
import sys

sys.setrecursionlimit(1<<30)
from io import BytesIO, IOBase
import math
import bisect
from math import inf
import random


adj = defaultdict(list)


def bfs1(node): 
    q = deque([(node, -1)])
    curr = q[0][0]
    while q : 
        curr, parent  = q.popleft()
        for nei in adj[curr]: 
            if nei == parent : 
                continue 
            q.append((nei, curr))

    return curr 



def bfs2(node):
    q = deque([(node, -1)])
    curr = q[0][0]
    lvl = 0

    while q : 

        l_q = len(q)

        for i in range(l_q): 
            curr, parent  = q.popleft()
            for nei in adj[curr]: 
                if nei == parent : 
                    continue 
                q.append((nei, curr))

        lvl += 1
    #print(curr)

    return lvl -1 

if __name__ == "__main__": 

    n = int(input())

    for i in range(1, n): 
        u, v = list(map(int, input().split(" ")))
        adj[u-1].append(v-1)
        adj[v-1].append(u-1)


    final_node = bfs1(0)
    #print(final_node)
    dist = bfs2(final_node)
    print(dist)