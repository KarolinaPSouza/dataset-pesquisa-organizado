n,x=map(int,input().split())
pr=list(map(int,input().split()))
pa=list(map(int,input().split()))
dd=list(zip(pr,pa))
dp=[0]*(x+1)
for i,k in dd:
    for j in range(x,i-1,-1):
        dp[j]=max(dp[j],dp[j-i]+k)
print(dp[x])

