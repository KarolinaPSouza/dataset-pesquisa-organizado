from collections import Counter as C
d=list(map(int,open(0).read().split()));x=d[1];a=d[2:];m=len(a)//2;s=[0]
for v in a[:m]:s+=[u+v for u in s]
t=[0]
for v in a[m:]:t+=[u+v for u in t]
c=C(t);print(sum(c[x-u]for u in s))