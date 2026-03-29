n,x=map(int,input().split())
wt=[*map(int,input().split())]
val=[*map(int,input().split())]
dp=[0]*(x+1)
for i in range(n):
    for j in range(x,wt[i]-1,-1):
        dp[j]=max(val[i]+dp[j-wt[i]],dp[j])
print(dp[x])