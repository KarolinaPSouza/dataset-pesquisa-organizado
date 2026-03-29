def main():
    x, z = map(int, input().split())
    prices = list(map(int, input().split()))
    pages = list(map(int, input().split()))


    dp = [0] * (z + 1)
    for cost, page in zip(prices, pages):
        for budget in range(z, cost - 1, -1):
            dp[budget] = max(dp[budget], dp[budget - cost] + page)

    print(dp[z])


main()