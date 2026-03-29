import sys
input = sys.stdin.readline

books, budget = map(int, input().split())
prices = list(map(int, input().split()))
pages = list(map(int, input().split()))

dp = [0]*(budget+1)
for book in range(books):
    price = prices[book]
    value = pages[book]
    for c in range(budget, price-1, -1):
        dp[c] = max(dp[c], dp[c-price] + value)

print(dp[budget])