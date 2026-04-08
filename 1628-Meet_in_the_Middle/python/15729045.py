import sys;from collections import Counter as C
d=list(map(int,sys.stdin.buffer.read().split()));x=d[1];t=d[2:];m=len(t)//2;s=[0]
for v in t[:m]:s+=[u+v for u in s]
r=[0]
for v in t[m:]:r+=[u+v for u in r]
c=C(r);print(sum(c[x-u] for u in s))