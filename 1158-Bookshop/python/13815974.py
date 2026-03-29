def max_pages(n, x, prices, pages):
    dp = [0] * (x + 1)

    for i in range(n):
        price = prices[i]
        page = pages[i]
        for j in range(x, price - 1, -1):  # backward to prevent reuse
            dp[j] = max(dp[j], dp[j - price] + page)

    return max(dp)


# Input
n, x = map(int, input().split())
prices = list(map(int, input().split()))
pages = list(map(int, input().split()))

print(max_pages(n, x, prices, pages))