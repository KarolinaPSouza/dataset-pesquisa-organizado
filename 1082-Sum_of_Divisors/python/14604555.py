# ---===
from collections import defaultdict, deque, Counter
from itertools import combinations, permutations
from functools import lru_cache, reduce
from heapq import heappush, heappop
from sys import stderr, stdout
from time import sleep
import sys
import os
import math
from math import floor, ceil, prod, gcd, comb

#                  lower_bound  upper_bound
from bisect import bisect_left, bisect_right, insort


def input():
    return sys.stdin.readline().rstrip()


def repeat(n=1):
    def wrapper(func):
        for i in range(n):
            debug(f"TEST {i + 1}", color="cyan")
            func()
    return wrapper


def read():
    lst = list(map(int, input().split()))
    return lst[0] if len(lst) == 1 else lst


def aread():  # for lists
    return list(map(int, input().split()))


def debug(*args, color="red", **kwargs):
    if not LOCAL:
        return
    colors = {
        "black": "30",
        "red": "31",
        "green": "32",
        "yellow": "33",
        "blue": "34",
        "magenta": "35",
        "cyan": "36",
        "white": "37",
    }
    code = colors.get(color.lower(), "31")
    print(f"\033[{code}m", end="", file=kwargs.get('file', stdout))
    print(*args, **kwargs)
    print(f"\033[0m", end="", file=kwargs.get('file', stdout))


# sys.setrecursionlimit(10**7)
cache = lru_cache(None)  # for older versions of python without @cache

LOCAL = "LOCAL" in os.environ
INF = 1_000_000_000_000_000_000  # 1e18 is actually FASTER than 2e9
MOD = 1_000_000_007
# ===---


def s(l, r):
    return (r - l + 1) * (l + r) // 2


n = read()

ans = 0

# floor(n/d)  only changes  O(sqrt n)  times

d = 1
while d <= n:
    q = n // d  # floor (n/d)

    r = n // q
    assert ceil(n / (q + 1)) <= d

    ans += s(d, r) * q
    ans %= MOD
    d = r + 1

print(ans)