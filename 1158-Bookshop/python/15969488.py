import sys
input = sys.stdin.readline

n, x = map(int, input().split())
pri = list(map(int, input().split()))
pag = list(map(int, input().split()))

dp = [0] * (x + 1)

for i in range(n):
    cost = pri[i]
    pages = pag[i]
    for j in range(x, cost - 1, -1):
        dp[j] = max(dp[j], dp[j - cost] + pages)

print(dp[x])