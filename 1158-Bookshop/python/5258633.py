n, x = map(int,input().split())
price = list(map(int,input().split()))
page = list(map(int,input().split()))
dp = [0] * (x + 1)
for k, v in zip(price, page):
    for j in range(x, k - 1, -1):
        dp[j] = max(dp[j], dp[j - k] + v)
print(dp[x])