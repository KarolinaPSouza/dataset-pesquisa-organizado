n, tot = map(int, input().split())
cost = list(map(int, input().split()))
pages = list(map(int, input().split()))
dp = [0] * (tot + 1)
for i in range(1, n + 1):
    c = cost[i - 1]
    p = pages[i - 1]
    for j in range(tot, c - 1, -1):
        dp[j] = max(dp[j], dp[j-c]+p) 

print(dp[tot])