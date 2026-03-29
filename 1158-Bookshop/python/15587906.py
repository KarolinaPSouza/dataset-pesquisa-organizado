import sys
input = sys.stdin.readline

n,x=map(int,input().split())
prices=list(map(int,input().split()))
pagess=list(map(int,input().split()))
mod = 10**9+7
dp = [0]*(x+1)
for i in range(n):
    price=prices[i]
    pages=pagess[i]
    for s in range(x,price-1,-1):
        dp[s]=max(dp[s],dp[s-price]+pages)
print(dp[x])