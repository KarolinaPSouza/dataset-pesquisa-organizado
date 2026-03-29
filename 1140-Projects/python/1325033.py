import sys
from _collections import defaultdict
input = sys.stdin.readline
n=int(input())
info = []
INFO = defaultdict(list)
for _ in range(n):
    a,b,p = map(int, input().split())
    INFO[b].append((a,p))
NUMS = [0] + sorted(INFO.keys())

# NUMS = [0]
# for b, _, _ in info:
#     if b != NUMS[-1]:
#         NUMS.append(b)
#   
N=len(NUMS)

RET = [0]*N
MAYOR = {}

for i in range(1, N):
    MAYOR[NUMS[i]] = i-1

def mayor(d):
    if d in MAYOR:
        return MAYOR[d]
    l=0
    h=N
    while l+1<h:
        m=(l+h)//2
        if NUMS[m] >= d:
            h=m
        else:
            l=m
    MAYOR[d] = l
    return l
#     ret = RET.get(NUMS[l],0)
#     if ret:
#         MAYOR[d] = ret
#     return ret


for b in NUMS:
    for a, p in INFO[b]:
        a_i = mayor(a)
        b_i = mayor(b) +1
        RET[b_i] = max(RET[a_i] + p, RET[b_i], RET[b_i-1])


print(RET[-1])

"""
3
1 5 10
2 4 8
7 8 5
"""