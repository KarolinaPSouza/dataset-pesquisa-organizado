n=int(input())
mod=10**9+7
res=0
i=1
while i<=n:
    q=n//i
    j=n//q
    s=(i+j)*(j-i+1)//2
    res=(res+s*q)%mod
    i=j+1
print(res)