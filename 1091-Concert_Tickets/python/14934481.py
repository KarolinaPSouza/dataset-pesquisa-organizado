from bisect import *
f=lambda:map(int,input().split())
n,_=f()
*K,=range(n+2)
H=-1,*sorted(f())
for t in f():
    i = bisect(H, t)
    # print(i)
    while K[i]-i: K[i], i = K[K[i]], K[i]
    print(H[i-1])
    K[i]-=i>1
