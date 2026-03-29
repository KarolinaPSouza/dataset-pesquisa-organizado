from bisect import *
m=10**6
I=input
n=int(I())
l=[[int(t) for t in I().split()] for _ in range(n)]

b=sorted(i+m*l[i][1] for i in range(n))
d=[0]
for x in b:
    a,_,p=l[x%m]
    d+=max(d[-1],d[bisect_left(b,m*a)]+p),

print(d[n])