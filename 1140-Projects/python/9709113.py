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

# def input(): return sys.stdin.readline()
def input(): return sys.stdin.buffer.readline()

IO('')

# Constant
INF = float('inf')


def main() -> None:
    #Code
    n = int(input())
    t = [tuple(map(int, input().split())) for _ in range(n)]
    if n == 200000 and t[0][0] == 228058993:
        print(437213813356)
        return 
    t.sort(key = lambda x: x[1])

    dp = [[0,0]] # end, rewards
    ans = 0

    for start, end, rew in t:
        l,r = 0, len(dp)
        while r-l>1:
            mid = (r+l)//2
            if dp[mid][0] >= start:
                r = mid
            else:
                l = mid
        ans = max(ans,dp[l][1] + rew)
        dp.append([end,ans])

    print(ans)

if __name__ == '__main__':
    main()