n, x = map(int, input().split())

prices = list(map(int, input().split()))
pages = list(map(int, input().split()))


dp = [0] * (x+1)


for price, page in zip(prices, pages):
    for i in range(x, price - 1, -1):
        dp[i] = max(dp[i], dp[i - price] + page)

print(dp[x])