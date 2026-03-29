import sys

input = sys.stdin.read
data = input().split()

idx = 0
n = int(data[idx]); idx += 1
x = int(data[idx]); idx += 1

h = [int(data[idx + i]) for i in range(n)]; idx += n
s = [int(data[idx + i]) for i in range(n)]

dp = [0] * (x + 1)

for i in range(n):
    cost = h[i]
    pages = s[i]
    for c in range(x, cost - 1, -1):
        dp[c] = max(dp[c], dp[c - cost] + pages)

print(dp[x])