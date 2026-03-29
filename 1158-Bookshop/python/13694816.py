n,x=map(int,input().split())
h=tuple(map(int,input().split()))
s=tuple(map(int,input().split()))
dp=[0]*(x+1)
mx=0
ans=0
for i in range(n):
    mx=min(mx+h[i],x)
    a=h[i]
    b=s[i]
    for j in range(mx,h[i]-1,-1):
        if dp[j-a]+b>dp[j]:
            dp[j]=dp[j-a]+b
print(max(dp))