from collections import*
from bisect import*
I=input
R=range
S=sorted
P=defaultdict(dict)
for _ in R(int(I())):
    a,b,p = map(int,I().split())
    P[b][a] = max(P[b].get(a,0),p)

D=S(P)
r=R(len(D))
E={D[i]:i for i in r}
A=[0]*len(P)

for i in r:
    A[i]=A[i-1]
    e=D[i]
    for s in S(P[e]):
        A[E[e]] = max(A[E[e]], A[bisect_left(D,s)-1] + P[e][s])
print(A[-1])