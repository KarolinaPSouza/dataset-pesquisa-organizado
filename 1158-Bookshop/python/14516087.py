n, x = map(int, input().split())
h = list(map(int, input().split()))
s = list(map(int, input().split()))

dp = [0] * (x+1)

for i in range(n):
    price, page = h[i], s[i]
    for w in range(x, price-1, -1):
        cand = dp[w-price] + page
        if cand > dp[w]:
            dp[w] = cand

print(dp[x])