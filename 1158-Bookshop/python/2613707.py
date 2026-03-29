n,m = map(int,input().split())
W = list(map(int,input().split()))
V = list(map(int,input().split()))
dp = [0 for _ in range(m+1)]
for w,v in zip(W,V):
    for j in range(m,w-1,-1):
        dp[j] = max(dp[j],dp[j - w]+v) 
print(dp[m])               