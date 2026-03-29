n, x = map(int, input().split())
h = list(map(int, input().split()))
s = list(map(int, input().split()))  

dp = [0] * (x + 1)

for i in range(n):
    price = h[i]
    pages = s[i]
    for c in range(x, price - 1, -1):  
        dp[c] = max(dp[c], dp[c - price] + pages)

print(max(dp))