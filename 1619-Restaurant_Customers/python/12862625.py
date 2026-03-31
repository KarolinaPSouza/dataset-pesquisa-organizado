import os
from sys import stdin
from collections import defaultdict
import bisect

# n = map(int, stdin.readline().split())
n = input()
n = int(n)

arr = []
dep = []

counter = defaultdict(int)

for i in range(n):
    a, b = map(int, stdin.readline().split())
    arr.append(a)
    dep.append(b)

    counter[a] += 1
    counter[b] -= 1

event = sorted(counter.keys())

run = 0
mx = 0

for e in event:
    run += counter[e]
    mx  = max(mx, run)

print(mx)