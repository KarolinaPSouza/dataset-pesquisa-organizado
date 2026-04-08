from collections import*
n,x,*t=map(int,open(0).read().split())
f=lambda a:(s:=[0],[s:=s+[w+v for w in s]for v in a])and s
c=Counter(f(t[n//2:]));print(sum(c[x-v]for v in f(t[:n//2])))