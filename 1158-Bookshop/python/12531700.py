def max_pages(n, x, prices, pages):
    dp = [0] * (x + 1)  # dp[j] = max pages with total price j

    for i in range(n):  # Iterate over books
        price, page = prices[i], pages[i]
        for j in range(x, price - 1, -1):  # Reverse to prevent reusing books
            dp[j] = max(dp[j], dp[j - price] + page)

    print(dp[x])  # Max pages we can buy within budget x

# Read input
n, x = map(int, input().split())
prices = list(map(int, input().split()))
pages = list(map(int, input().split()))

max_pages(n, x, prices, pages)