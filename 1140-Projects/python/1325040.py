import sys
from collections import defaultdict as d
I = sys.stdin.readline
n=int(I())
info = []
INFO = d(list)
for _ in range(n):
    a,b,p = map(int, I().split())
    INFO[b].append((a,p))
NUMS = [0] + sorted(INFO.keys())

N=len(NUMS)

R = [0]*N

def m(d):
    l=0
    h=N
    while l+1<h:
        m=(l+h)//2
        if NUMS[m] >= d:
            h=m
        else:
            l=m
    return l

for b in NUMS:
    for a, p in INFO[b]:
        a_i = m(a)
        b_i = m(b) +1
        R[b_i] = max(R[a_i] + p, R[b_i], R[b_i-1])


print(R[-1])