# for index, value in enumerate(list)
# '{:02d}'.format(1) --> 001
# '{0:.2f}'.format(1.5) --> 1.50
# Stack is DFS, Queue is BFS
# AND --> &, OR --> |, XOR --> ^
# (a/b)%c = (a mod (b * c) / b) mod c
# (a/b)%c = (a mod c * b^(c-2) mod c) mod c ||| c is prime number
# To use custom compare in heapq, make a Class have a __lt__ func

import sys
from heapq import heapify, heappush, heappop
from collections import defaultdict as dd, deque as dq, Counter as Ct, OrderedDict
#from math import gcd,log,log2,log10
#from bisect import bisect_left, bisect_right
#from typing import List, Tuple
#from functools import lru_cache, cmp_to_key

def IO(name = ''):
    if name:
        sys.stdin = open(name+'.INP', 'r')
        sys.stdout = open(name+'.OUT', 'w')

#def input(): return sys.stdin.readline()
def input(): return sys.stdin.buffer.readline()
print = sys.stdout.write
# sys.setrecursionlimit(int(1e6))

IO('')

# Constant
INF = 1<<60
maxn = int(1e5)
edge = [[] for _ in range(maxn)]
D = [[INF,INF] for _ in range(maxn)]

def main() -> None:
    #Code
    n,m = map(int, input().split())
    for _ in range(m):
        u,v,w = map(int, input().split())
        u-=1
        v-=1
        edge[u].append((v,w))

    Djikstra()
    print(str(min(D[n-1][1],D[n-1][0])))

def Djikstra():
    D[0][0] = 0
    D[0][1] = 0
    h = [(0,0,1)]
    heapify(h)
    while h:
        d,u,avail = heappop(h)

        if D[u][avail] < d: continue

        for v,w in edge[u]:
            if avail:
                if D[v][1] > d+w:
                    D[v][1] = d+w
                    heappush(h,(D[v][1],v,1))
                if D[v][0] > d+w//2:
                    D[v][0] = d+w//2
                    heappush(h,(D[v][0],v,0))
            else:
                if D[v][0] > d+w:
                    D[v][0] = d+w
                    heappush(h,(D[v][0],v,0))

if __name__ == '__main__':
    main()