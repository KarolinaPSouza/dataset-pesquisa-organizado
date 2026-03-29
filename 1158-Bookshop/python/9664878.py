# for index, value in enumerate(list)
# '{:02d}'.format(1) --> 001
# '{0:.2f}'.format(1.5) --> 1.50
# Stack is DFS, Queue is BFS
# AND --> &, OR --> |, XOR --> ^
# (a/b)%c = (a mod (b * c) / b) mod c
# (a/b)%c = (a mod c * b^(c-2) mod c) mod c ||| c is prime number
# To use custom compare in heapq, make a Class have a __lt__ func

import sys
# from heapq import heapify, heappush, heappop
# from collections import defaultdict as dd, deque as dq, Counter as Ct, OrderedDict
# from math import gcd,log,log2,log10
# from bisect import bisect_left, bisect_right
# from typing import List, Tuple
# from functools import lru_cache

def IO(name = ''):
    if name:
        sys.stdin = open(name+'.INP', 'r')
        sys.stdout = open(name+'.OUT', 'w')

# def input(): return sys.stdin.readline()[:-1]
def input(): return sys.stdin.buffer.readline()[:-1]

IO('')

INF = float('inf')

def main():
    #Code
    n,X = map(int, input().split())
    prices = list(map(int, input().split()))
    pages = list(map(int, input().split()))
    dp = [0] * (X+1)

    for price,page in zip(prices,pages):
        for j in range(X, price-1, -1):
            dp[j] = max(dp[j], page + dp[j-price])

    print(dp[X])


if __name__ == '__main__':
    main()