import sys
input = sys.stdin.readline

n, x = map(int, input().split())
price = list(map(int, input().split()))
pages = list(map(int, input().split()))

dp = [0] * (x + 1)

for i in range(n):
    h = price[i]
    s = pages[i]
    for t in range(x, h - 1, -1):
        dp[t] = max(dp[t], dp[t - h] + s)

print(max(dp))