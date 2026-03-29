n, x = map(int, input().split())

prices = list(map(int, input().split()))
pages = list(map(int, input().split()))

dp = [0] * (x + 1)

for i in range(n):
    price = prices[i]
    page_count = pages[i]

    for j in range(x, price - 1, -1):
        if dp[j - price] + page_count > dp[j]:
            dp[j] = dp[j - price] + page_count

print(dp[x])