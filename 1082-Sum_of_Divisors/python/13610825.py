def sum(a,b):
    return (b*(b+1))//2 - (a*(a-1))//2
mod=10**9+7
n=int(input())
p=2
q=2
ans=n
while q<n:
    times=n//p
    q=(n//times)+1
    ans=(ans+(sum(p,q-1)*times))%mod
    p=q
print(ans)