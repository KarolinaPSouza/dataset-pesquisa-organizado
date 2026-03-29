n , x = map(int,input().split())
h = list(map(int,input().split()))
f = list(map(int,input().split()))

dp = [0]*(x+1)

for i in range(n):
    price = h[i]
    pages = f[i]
    for j in range(x,price-1,-1):
        if dp[j - price] + pages > dp[j]:
                dp[j] = dp[j - price] + pages

print(dp[x])
