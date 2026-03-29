import sys

data = list(map(int, sys.stdin.read().strip().split()))
it = iter(data)
n, x = next(it), next(it)
h = [next(it) for _ in range(n)]
s = [next(it) for _ in range(n)]

dp = [0]*(x+1)
for price, pages in zip(h, s):
    for b in range(x, price-1, -1):    # go DOWN
        dp[b] = max(dp[b], dp[b-price] + pages)

print(dp[x])