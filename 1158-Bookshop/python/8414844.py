import sys
# sys.setrecursionlimit(10**5+5)
input = sys.stdin.readline
from collections import defaultdict
from itertools import accumulate
import math

def inputa():
    return list(map(int, input().split()))

def inputs():
    return list(input().strip())

def solve():
    n,k = inputa()
    cs = inputa()
    ss = inputa()

    ans = [0] * (k+1)

    for c,s in zip(cs,ss):
        for j in range(k,-1,-1):
            if j-c>=0:
                ans[j] = max(ans[j], ans[j-c] + s)

    print(max(ans))

if __name__ == "__main__":
    test = 1
    # test = int(input())
    while(test):
        solve()
        test-=1