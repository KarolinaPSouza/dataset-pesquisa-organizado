n,x=map(int,input().split())
h=list(map(int,input().split()))
s=list(map(int,input().split()))
dp=[0]*(x+1)
for i in range(n):
    w,v=h[i],s[i]
    for j in range(x,w-1,-1):
        dp[j]=dp[j] if dp[j]>dp[j-w]+v else dp[j-w]+v
print(dp[x])