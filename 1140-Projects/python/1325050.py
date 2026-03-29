import sys
I = sys.stdin.readline
n=int(I())
P = {0:[]}
for _ in range(n):
    a,b,p = map(int, I().split())
    P[b] = P.get(b,[]) + [(a,p)]
Q = [0] + sorted(P.keys())

N=len(Q)

R = [0]*N

def M(d):
    l=0
    h=N
    while l+1<h:
        m=(l+h)//2
        if Q[m] >= d:
            h=m
        else:
            l=m
    return l

for b in Q:
    for a, p in P[b]:
        R[M(b)+1] = max(R[M(a)] + p, R[M(b)+1], R[M(b)])


print(R[-1])