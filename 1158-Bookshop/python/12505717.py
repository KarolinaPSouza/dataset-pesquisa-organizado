def solve(max_sum, prices, pages):
    dp = [0] * (max_sum + 1)

    for price, page in zip(prices, pages):
        for x in range(max_sum, price - 1, -1):
            dp[x] = max(dp[x], dp[x - price] + page)

    return dp[max_sum]


_, max_sum = list(map(int, input().split()))
prices = list(map(int, input().split()))
pages = list(map(int, input().split()))

print(solve(max_sum, prices, pages))