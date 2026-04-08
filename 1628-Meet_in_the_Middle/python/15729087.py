from collections import*
n,x,*t=map(int,open(0).read().split());n//=2
f=lambda a:(s:=[0],[s:=s+[w+v for w in s]for v in a],s)[-1]
c=Counter(f(t[n:]));print(sum(c[x-v]for v in f(t[:n])))