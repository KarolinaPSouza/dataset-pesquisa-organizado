from collections import *
I=input
n,k=map(int,I().split())
a=I().split()
def f(a):
 d=[0]
 for i in a:
  d+=[int(i)+j for j in d]
 return d
n//=2
d=Counter(f(a[:n]))
print(sum(d[k-i] for i in f(a[n:])))