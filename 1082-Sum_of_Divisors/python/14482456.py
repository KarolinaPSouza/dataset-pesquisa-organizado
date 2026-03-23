import math
mod=1000000007
mod1=998244353
inf=10**18+10

def sum(l,r):
    x=(l-1)*(l)//2
    y=r*(r+1)//2
    return (y-x)%mod

t=1
for i in range(t):
    n=int(input())

    l=1
    ans=0
    while l<=n:
        val=n//l
        r=n//val
        ans+=sum(l,r)*val
        ans%=mod
        l=r+1
    print(ans)