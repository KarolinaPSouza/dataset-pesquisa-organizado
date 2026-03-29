import sys
input = sys.stdin.read
def max_pages(n, budget, prices, pages):
    dp = [0] * (budget + 1)

    for i in range(n):
        price, page = prices[i], pages[i]
        if price > budget:
            continue
        for j in range(budget, price - 1, -1):
            dp[j] = max(dp[j], dp[j - price] + page)

    return dp[budget]

# Input más rápido para evitar TLE
data = input().split()
n, budget = int(data[0]), int(data[1])
prices = list(map(int, data[2:n+2]))
pages = list(map(int, data[n+2:2*n+2]))

print(max_pages(n, budget, prices, pages))