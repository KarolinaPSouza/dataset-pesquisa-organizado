def max_pages(n, x, prices, pages):
    dp = [0] * (x + 1)
    for i in range(n):
        price = prices[i]
        page = pages[i]
        for j in range(x, price - 1, -1):
            dp[j] = max(dp[j], dp[j - price] + page)
    return dp[x]

import sys
data = sys.stdin.read().split()
if data:
    n = int(data[0])
    x = int(data[1])
    prices = list(map(int, data[2:2+n]))
    pages = list(map(int, data[2+n:2+2*n]))
else:
    n, x = map(int, input().split())
    prices = list(map(int, input().split()))
    pages = list(map(int, input().split()))
print(max_pages(n, x, prices, pages))