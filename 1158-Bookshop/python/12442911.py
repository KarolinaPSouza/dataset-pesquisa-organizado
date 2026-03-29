n, m = list(map(int,input().split()))
prices = list(map(int,input().split()))
pages = list(map(int,input().split()))
dp = [0]*(m+1)
for j in range(n):
    pr = prices[j]
    pa = pages[j]
    for i in range(m,pr-1,-1):
        dp[i] = max(dp[i],dp[i-pr]+pa)
print(max(dp))