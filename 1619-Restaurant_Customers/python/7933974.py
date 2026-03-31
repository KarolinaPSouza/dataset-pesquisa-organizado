#user : @sixthcore
import math
from math import log2, sqrt, log10, log
from heapq import heapify, heappop, heappush, heappushpop
from math import floor, ceil
import sys
from collections import Counter, defaultdict
I = lambda: list(map(int, input().split()))
MAP = lambda: map(int, input().split())
SI = lambda: list(input().strip())
input = sys.stdin.readline
sys.setrecursionlimit(10000)
from itertools import combinations
import heapq
from collections import deque
INF = float('inf')

for _ in range(1):
    N, = I()
    time = defaultdict(int)
    keys = []
    for i in range(N):
        a, b = MAP()
        time[a] += 1
        time[b] += -1
        keys.append(a)
        keys.append(b)
    keys.sort()
    arr = [time[i] for i in keys]
    for i in range(1, len(keys)):
        arr[i] += arr[i-1]
    print(max(arr))