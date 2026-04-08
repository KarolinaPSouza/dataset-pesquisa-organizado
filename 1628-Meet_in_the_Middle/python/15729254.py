from collections import*
n,x,*t=map(int,open(0).read().split())
d,i=[0],n
while i:i-=1;i-n//2or(z:=Counter(d),d:=[0]);d+=[s for k in d if(s:=k+t[i])<=x]
print(sum(z[x-k]for k in d))