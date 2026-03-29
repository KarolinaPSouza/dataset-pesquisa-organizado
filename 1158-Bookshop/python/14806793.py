import sys

data = list(map(int, sys.stdin.buffer.read().split()))
it = iter(data)

n = next(it)
x = next(it)
prices = [next(it) for _ in range(n)]
pages = [next(it) for _ in range(n)]

dp = [0] * (x + 1)

for p, s in zip(prices, pages):
    # j goes from x down to p; no inner if needed
    for j in range(x, p - 1, -1):
        v = dp[j - p] + s
        if v > dp[j]:
            dp[j] = v

print(dp[x])