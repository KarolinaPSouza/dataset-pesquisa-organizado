import sys
I = sys.stdin.readline
n=int(I())
INFO = {0:[]}
for _ in range(n):
    a,b,p = map(int, I().split())
    INFO[b] = INFO.get(b,[]) + [(a,p)]
NUMS = [0] + sorted(INFO.keys())

N=len(NUMS)

R = [0]*N

def M(d):
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
        a_i = M(a)
        b_i = M(b) +1
        R[b_i] = max(R[a_i] + p, R[b_i], R[b_i-1])


print(R[-1])