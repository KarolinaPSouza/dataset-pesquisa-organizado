from bisect import *
f=lambda:map(int,input().split())
n,_=f()
K = list(range(n+1))
H = sorted(f())
for t in f():
    i = bisect(H, t)
    while K[i] != i: K[i], i = K[K[i]], K[i]
    if i:
        print(H[i-1])
        K[i] -= 1
    else:
        print(-1)