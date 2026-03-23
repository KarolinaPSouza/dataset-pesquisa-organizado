import sys

# import heapq, itertools, functools, bisect
from collections import defaultdict, Counter, deque
from bisect import bisect_left, bisect_right
from itertools import accumulate, permutations, combinations, chain
from heapq import heappush, heappop, heapify
from math import ceil, gcd, log2, sqrt, isqrt, dist, hypot, isinf, prod, atan, pi, inf, log#, sin, cos, tan
# import random
# import time
# random.seed(time.time())
try: from math import lcm
except: lcm = lambda a,b: a//gcd(a,b)*b

input = sys.stdin.readline

get_int = lambda : int(input())
get_ints = lambda : map(int, input().split())
get_int_list = lambda : list(map(int, input().split()))
get_float = lambda : float(input())
get_floats = lambda : map(float, input().split())
get_float_list = lambda : list(get_floats = lambda : map(float, input().split()))
get_str = lambda : input()[:-1]
get_str_list = lambda : input().split()
get_multiple_types = lambda *types : map(lambda p: p[0](p[1]), zip(types, input().split()))

def get_unweighted_graph(n, m):
    adj = [[] for _ in range(n+1)]
    for _ in range(m):
        u, v = get_ints()
        adj[u].append(v)
        adj[v].append(u)
    return adj
get_tree = lambda n : get_unweighted_graph(n, n-1)

# My aliases
intt = get_int
ints = get_ints
intsl = get_int_list
floatt = get_float
floats = get_floats
floatsl = get_float_list
strr = get_str
strsl = get_str_list
line = get_multiple_types
get_graph = get_unweighted_graph
tree = get_tree

# trie_dd = lambda: defaultdict(trie_dd)

iprint = lambda *d : print(*d, flush=True)
tprint = lambda *d : print("\t", *d)
aprint = lambda a, sep=" " : tprint(sep.join(map(str, a)))

class SegmentTree:
    def __init__(self, data, default=0, func=max):
        """initialize the segment tree with data"""
        self._default = default
        self._func = func
        self._len = len(data)
        self._size = _size = 1 << (self._len - 1).bit_length()

        self.data = [default] * (2 * _size)
        self.data[_size:_size + self._len] = data
        for i in reversed(range(_size)):
            self.data[i] = func(self.data[i + i], self.data[i + i + 1])

    def __delitem__(self, idx):
        self[idx] = self._default

    def __getitem__(self, idx):
        return self.data[idx + self._size]

    def __setitem__(self, idx, value):
        idx += self._size
        self.data[idx] = value
        idx >>= 1
        while idx:
            self.data[idx] = self._func(self.data[2 * idx], self.data[2 * idx + 1])
            idx >>= 1

    def __len__(self):
        return self._len

    def query(self, start, stop):
        """func of data[start, stop)"""
        start += self._size
        stop += self._size

        res_left = res_right = self._default
        while start < stop:
            if start & 1:
                res_left = self._func(res_left, self.data[start])
                start += 1
            if stop & 1:
                stop -= 1
                res_right = self._func(self.data[stop], res_right)
            start >>= 1
            stop >>= 1

        return self._func(res_left, res_right)

    def __repr__(self):
        return "SegmentTree({0})".format(self.data)

def main():
    # _t = intt()
    _t = 1
    for _ in range(_t):
        n, m = ints()
        h = intsl()
        t = intsl()

        h.sort()
        st = SegmentTree(range(n), default=-1)

        for ti in t:
            j = bisect_right(h, ti)
            k = st.query(0, j)
            # print(h, ti, j, k)
            tprint(h[k] if k != -1 else k)
            st[k] = -1


if __name__ == "__main__":
    main()
    # print(chr(sum(range(ord(min(str(not())))))))