# for index, value in enumerate(list)
# '{:02d}'.format(1) --> 001
# '{0:.2f}'.format(1.5) --> 1.50
# Stack is DFS, Queue is BFS
# AND --> &, OR --> |, XOR --> ^
# (a/b)%c = (a mod (b * c) / b) mod c
# (a/b)%c = (a mod c * b^(c-2) mod c) mod c ||| c is prime number
# To use custom compare in heapq, make a Class have a __lt__ func

import sys
#from heapq import heapify, heappush, heappop
#from collections import defaultdict as dd, deque as dq, Counter as Ct, OrderedDict
#from math import gcd,log,log2,log10
#from bisect import bisect_left, bisect_right
#from typing import List, Tuple
#from functools import lru_cache, cmp_to_key

def IO(name = ''):
    if name:
        sys.stdin = open(name+'.INP', 'r')
        sys.stdout = open(name+'.OUT', 'w')

def input(): return sys.stdin.readline()
#def input(): return sys.stdin.buffer.readline()

# sys.setrecursionlimit(int(1e6))

IO('')

# Constant
INF = 1<<40
maxn = 2501
trace = [-1] * maxn
edge = []
D = [INF] * maxn

def main() -> None:
    #Code
    n,m = map(int, input().split())
    for _ in range(m):
        edge.append(tuple(map(int, input().split())))

    bellman(n)
    findNeg(n)

def bellman(n):
    D[1] = 0
    for _ in range(n):
        for u,v,w in edge:
            if D[v] > D[u] + w:
                D[v] = D[u] + w
                trace[v] = u

def findNeg(n):
    negNode = -1
    for u,v,w in edge:
        if D[v] > D[u] + w and D[u] != INF:
            D[v] = -INF
            negNode = v 

    if negNode == -1: return print("NO")

    print("YES")
    u = negNode
    for _ in range(n):
        u = trace[u]

    negCycle = [u]
    v=trace[u]
    while v!=u:
        negCycle.append(v)
        v=trace[v]

    negCycle.append(u)

    return print(*reversed(negCycle))


if __name__ == '__main__':
    main()