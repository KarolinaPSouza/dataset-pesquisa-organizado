# # from sys import stdin
# # def input(): return stdin.readline()[:-1]

n, x = map(int, input().split())
prices = list(map(int, input().split()))
pages = list(map(int, input().split()))

dp = [-1]*(x + 1)
dp[0] = 0
for price, page in zip(prices, pages):
    for j in range(x, price - 1, -1):
        dp[j] = max(dp[j - price] + page, dp[j])

print(max(dp))

# from sys import stdin
# def input(): return stdin.readline()[:-1]

# n, p = map(int, input().split())
# price = list(map(int, input().split()))
# pages = list(map(int, input().split()))

# dp = [0] * (p + 1)
# dp[0] = 0
# for pri, pag in zip(price, pages):
#     for j in range(p, pri - 1, -1):
#         dp[j] = max(dp[j], dp[j - pri] + pag)
# print(max(dp))