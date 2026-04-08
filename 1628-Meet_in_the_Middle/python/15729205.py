from collections import*
n,x,*t=map(int,open(0).read().split())
d=[0];i=n
while i:
 i-=1
 if i==n//2:z=Counter(d);d=[0]
 d+=[j+t[i]for j in d]
print(sum(z[x-j]for j in d))