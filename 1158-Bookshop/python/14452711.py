import sys
input = sys.stdin.readline

n, x = list(map(int, input().split()))
h, s = [list(map(int, input().split())) for _ in range(2) ]



dp = [0] * (x+1)
row = []
#i = prices
#j = current book

for j in range(n):
    price, pages = h[j], s[j]
    # loop backwards to avoid reusing the same book multiple times
    for i in range(x, price - 1, -1):
        dp[i] = max(dp[i], dp[i - price] + pages)

print(max(dp))


"""
for j in range(n):
    for i in range(x+1):
        if dp[i]<=0 and i!=x: continue
        if i>=h[j]:
            dp[i-h[j]] = max(dp[i-h[j]], dp[i] + s[j])
  print(dp[0])
 """

"""
dp = [[0 for _ in range(x+1)] for _ in range(n+1)]
for i,v in enumerate(dp):
    print(i)
    for j, vv in enumerate(v):
        if i<len(dp)-1:
            dp[i+1][j] = max(dp[i+1][j], dp[i][j] )
            if j>=h[i]:
                dp[i+1][j-h[i]] = max(dp[i+1][j-h[i]], dp[i][j] + s[i])
 print(max(dp[-1]))
"""


