import sys
import math
from collections import defaultdict, deque, Counter
from bisect import bisect_left, bisect_right, insort_right, insort_left

def input():
    return sys.stdin.readline().strip()

def print_flush(x):
    print(x)
    sys.stdout.flush()

def inp():
    return int(input())

def inlt():
    return list(map(int, input().split()))

def insr():
    return list(input())

def invr():
    return map(int, input().split())

def sin():
    return input()

def solve():
    k = inp()
    arr = []
    for _ in range(k):
        x, y, v = inlt()
        arr.append((x, y, v))

    arr.sort(key=lambda t: t[1])
    fin = [t[1] for t in arr]

    dp = [0] * (k + 1)

    for i in range(1, k + 1):
        x, y, v = arr[i - 1]
        idx = bisect_right(fin, x - 1)
        dp[i] = max(dp[i - 1], dp[idx] + v)

    print(dp[k])

if __name__ == "__main__":
    solve()