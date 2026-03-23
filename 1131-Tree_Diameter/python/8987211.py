import copy
import sys, os, io
from collections import *
from bisect import *

import math
from math import sqrt
from heapq import heapify, heappop, heappush

#from functools import cache

from itertools import accumulate, product, combinations, combinations_with_replacement, permutations, groupby, cycle
from bisect import bisect_left, bisect_right
from string import ascii_lowercase,ascii_uppercase

sys.setrecursionlimit(10**8)

mod = int(1e9) + 7
inf = float("inf")
# print(os.path.dirname(os.path.abspath(__file__)))
# input_file_path = os.path.dirname(os.path.abspath(__file__))
local_ = False
from io import BytesIO, IOBase
BUFSIZE = 4096
class FastIO(IOBase):
    newlines = 0

    def __init__(self, file):
        self._fd = file.fileno()
        self.buffer = BytesIO()
        self.writable = "x" in file.mode or "r" not in file.mode
        self.write = self.buffer.write if self.writable else None

    def read(self):
        while True:
            b = os.read(self._fd, max(os.fstat(self._fd).st_size, BUFSIZE))
            if not b:
                break
            ptr = self.buffer.tell()
            self.buffer.seek(0, 2), self.buffer.write(b), self.buffer.seek(ptr)
        self.newlines = 0
        return self.buffer.read()

    def readline(self):
        while self.newlines == 0:
            b = os.read(self._fd, max(os.fstat(self._fd).st_size, BUFSIZE))
            self.newlines = b.count(b"\n") + (not b)
            ptr = self.buffer.tell()
            self.buffer.seek(0, 2), self.buffer.write(b), self.buffer.seek(ptr)
        self.newlines -= 1
        return self.buffer.readline()

    def flush(self):
        if self.writable:
            os.write(self._fd, self.buffer.getvalue())
            self.buffer.truncate(0), self.buffer.seek(0)

class IOWrapper(IOBase):
    def __init__(self, file):
        self.buffer = FastIO(file)
        self.flush = self.buffer.flush
        self.writable = self.buffer.writable
        self.write = lambda s: self.buffer.write(s.encode("ascii"))
        self.read = lambda: self.buffer.read().decode("ascii")
        self.readline = lambda: self.buffer.readline().decode("ascii")

sys.stdout = IOWrapper(sys.stdout)
file_path = os.path.join(os.path.dirname(os.path.realpath(__file__)), 'in.txt')
# if os.path.exists(file_path): #os.path.exists('in.txt'):
if os.path.exists("C://Users//mridu//Python_Code//CPPython//in.txt"): #os.path.exists('in.txt'):
    local_ = True
if os.path.exists("in.txt"):
    sys.stdin = open("in.txt", "r")
    sys.stdout = open("out.txt", "w")

#input = sys.stdin.buffer.readline
input = sys.stdin.readline
#print = sys.stdout.write

def lst():
    return list(map(int, input().strip().split()))


def integer():
    return int(input())

def ceil(x,y):
    return int(-(-x  // y))

def st():
    s = input()
    if s[-1]=='\n':
        s = s[:-1]
    return s


def matrixNum(m):
    return [lst() for i in range(m)]

def matrixStr(m):
    return [list(st()) for i in range(m)]

class DSU:
    def __init__(self, n) -> None:
        self.rank = [0] * (n + 1)
        self.parent = [0] * (n + 1)

        for i in range(n + 1):
            self.parent[i] = i

    def find(self, x) -> int:
        if self.parent[x] == x:
            return x
        return self.find(self.parent[x])

    def union(self, a, b) -> int:
        x = self.find(a)
        y = self.find(b)

        if x == y:
            return 1

        if self.rank[x] < self.rank[y]:
            self.parent[x] = y

        elif self.rank[x] > self.rank[y]:
            self.parent[y] = x

        else:
            self.parent[y] = x
            self.rank[x] += 1

        return 0

def gh(out,s=' '):
    if isinstance(out, list):
        out = s.join(map(str, out))
    # print(out)
    ans.append(out)

m = 1e0
_prime = [i for i in range(int(m+100))]
_prime[0] = _prime[1] = -1
for i in range(2,1+int(sqrt(len(_prime)))):
    if _prime[i] ==i:
        for j in range(i*i,len(_prime),i):
            _prime[j] = i

s = set()
for i in range(len(_prime)):
    if _prime[i]==i:
        s.add(i)

def djisktra(src,d,n):
    a = []
    heappush(a,[0,src])
    dist = [inf]*(n+1)
    dist[src] = 0

    while a:
        di, u = heappop(a)


        if dist[u]<di:
            continue

        for j,w in d[u]:
            if di+w<dist[j]:
                dist[j] = di+w
                heappush(a,[dist[j],j])

    return dist

yes, no = "Yes", "No"

ans = []


dir = [[0,1],[1,0],[0,-1],[-1,0],[1,-1],[-1,1],[1,1],[-1,-1]]
# dir = [[-1,-1],[-1,1],[1,1],[1,-1]]
# dir = {'U':[-1,0],'R':[0,1],'D':[1,0],'L':[0,-1]}
# dir = dir.values()
def h():
    n = lst()
    a = lst()
    return *n,a

def hh():
    n = lst()
    a = [integer() for i in range(n[0])]
    return *n,a

if local_:
    def de(*args):
        e = ' '.join(map(str,args))
        sys.stderr.write(e+'\n')
        # print('==========',*args)

else:
    def de(*args):
        return 135


class Tree:
    def __init__(self, g=None, edges=None, root=0, vals=[]):
        if edges is not None:
            self.n = n = len(edges) + 1
            self.g = g = [[] for _ in range(n)]
            for u, v in edges:
                self.g[u].append(v)
                self.g[v].append(u)
        else:
            self.n = n = len(g)
            self.g = g
        self.root = root
        self.parent = parent = [-1] * n
        stk = [root]
        self.order = order = [root]
        self.depth = depth = [0] * n

        while stk:
            u = stk.pop()

            for v in g[u]:
                if v != root and parent[v] == -1:
                    depth[v] = depth[u] + 1
                    parent[v] = u
                    stk.append(v)
                    order.append(v)
        self.sizes = sizes = [1] * n
        self.sub_tree_sum = sub_tree_sum = vals[::]
        for u in reversed(order):
            for v in g[u]:
                if v != parent[u]:
                    sizes[u] += sizes[v]
                    if sub_tree_sum:
                        sub_tree_sum[u] += sub_tree_sum[v]

    def is_leaf(self, u):
        return self.children_count(u) == 0

    def children_count(self, u):

        return len(self.g[u]) - (u != self.root)

    def children(self, u):

        for v in self.g[u]:
            if v != self.parent[u]:
                yield v

    def dp_from_root(self, f, alpha):
        data = [0] * self.n
        data[self.root] = alpha
        for u in self.order():
            for v in self.g[u]:
                if v != self.parent[u]:
                    data[v] = f(data[u], u, v)
        return data

    def dp_from_leaf(self, merge, unit, f, g):
        data = [unit] * self.n
        for u in reversed(self.order):

            for v in self.g[u]:
                if v != self.parent[u]:
                    data[u] = merge(data[u], f(data[v], u, v))
            data[u] = g(data[u], u)
        return data

    def rerooting(self, merge, unit, f, g, debug=False):

        upper = [unit] * (self.n)
        lower = [unit] * (self.n)

        ch = self.children
        pa = self.parent

        lower = self.dp_from_leaf(merge, unit, f, g)
        if debug:
            print("dp of root:", lower)

        for v in self.order:
            cc = list(ch(v))

            deg = len(cc)

            Left = [unit]
            x = unit
            for c in cc:
                x = merge(x, f(lower[c], v, c))
                Left.append(x)

            Right = [unit]
            y = unit
            for c in cc[::-1]:
                y = merge(y, f(lower[c], v, c))
                Right.append(y)
            Right = Right[::-1]

            for i in range(deg):
                c = cc[i]

                a = merge(Left[i], Right[i + 1])

                if v != self.root:
                    b = merge(a, f(upper[v], v, pa[v]))
                else:
                    b = a

                upper[c] = g(b, v)

        A = [unit] * (self.n)
        for v in range(self.n):
            if v != self.root:
                a = f(upper[v], v, pa[v])
            else:
                a = unit

            for c in ch(v):
                a = merge(a, f(lower[c], v, c))
            A[v] = g(a, v)
        return A

from types import GeneratorType
import os,sys,random,threading
from random import randint
from copy import deepcopy
from io import BytesIO, IOBase
from types import GeneratorType
from functools import lru_cache, reduce
from bisect import bisect_left, bisect_right
from collections import Counter, defaultdict, deque
from itertools import accumulate, combinations, permutations
from heapq import  heapify, heappop, heappush
from typing import Generic, Iterable, Iterator, TypeVar, Union, List
from string import ascii_lowercase, ascii_uppercase
from math import ceil, floor, sqrt, pi, factorial, gcd, log, log10, log2, inf
from decimal import Decimal, getcontext

def bootstrap(f, stack=[]):   #yield
    def wrappedfunc(*args, **kwargs):
        if stack:
            return f(*args, **kwargs)
        else:
            to = f(*args, **kwargs)
            while True:
                if type(to) is GeneratorType:
                    stack.append(to)
                    to = next(to)
                else:
                    stack.pop()
                    if not stack:
                        break
                    to = stack[-1].send(to)
            return to
    return wrappedfunc


def solve():
    n = integer()

    adj = defaultdict(list)
    # adj = defaultdict(list)
    for i in range(n-1):
        u,v = lst()
        u-=1
        v-=1
        adj[u].append(v)
        adj[v].append(u)
    # de(adj)
    dp = [0]*(n+1)
    res = [0]
    @bootstrap
    def dfs(u,p):

        for v in adj[u]:
            if v==p:continue
            yield dfs(v,u)
            res[0] = max(res[0], dp[u]+dp[v]+1)
            dp[u] = max(dp[u],1+dp[v])

        # for v in adj[u]:
        #     if v==p:continue





        yield None



    dfs(0,-1)
    gh(res[0])






t = 1

# t = integer()

for _ in range(t):
    de('testcase:',1+_)
    solve()

print("\n".join(map(str, ans)))
