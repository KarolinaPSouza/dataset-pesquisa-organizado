n, x = map(int, input().split())
h = list(map(int, input().split()))
s = list(map(int, input().split()))

dp =[0] * (x + 1)

for i in range(n):
    price = h[i]
    page = s[i]

    for j in range(x, price - 1, -1):
        dp[j] = max(dp[j], dp[j - price] + page)

print(max(dp))