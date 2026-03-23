# Python CP Template

import sys
import math
from collections import defaultdict, deque, Counter
from itertools import permutations, combinations
from bisect import bisect_left, bisect_right
from heapq import heappush, heappop
from functools import lru_cache

sys.setrecursionlimit(10**6)
input = lambda: sys.stdin.readline().strip()

MOD = 10**9 + 7
INF = float('inf')

# ========== Utility Functions ==========

def print_yes(): print("YES")
def print_no(): print("NO")

def lcm(a, b): return abs(a*b) // math.gcd(a, b)



# ========== Solve Function ==========

def solve():

    n = int(input())
    ans = 0

    m = int(math.sqrt(n)) 
    for i in range(1,m+1):
        ans += i* (n//i)
        ans = (ans % MOD)

    for i in range(1,m+1):
        last = n // i
        first = n // (i + 1) + 1
        if (first > m and last > m) == False:
            continue

        a = first + last;
        b = last - first + 1;
        if (a % 2 == 0):
            a //= 2
        else:
            b //= 2

        sum = ((a%MOD) * (b% MOD)) % MOD

        sum %= MOD;
        sum = (sum *i)%MOD
        ans = (ans + sum) % MOD


    print(ans)

def main():
    # For multiple test cases:
    # t = int(input())
    # for _ in range(t):
    #     solve()

    solve()

if __name__ == "__main__":
    main()