MOD =10**9+7
n=int(input())
ans=0
d=1
while d<=n:
    v=n //d
    last=n //v    
    cnt=last-d+1
    s=(d + last)*cnt // 2
    ans=(ans+s%MOD*v)% MOD
    d=last+1
print(ans%MOD)