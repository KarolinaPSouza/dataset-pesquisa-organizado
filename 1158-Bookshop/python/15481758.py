import sys
input = lambda: sys.stdin.readline().strip()
n,x = map(int, input().split())
h = list(map(int, input().split()))
s = list(map(int, input().split()))

dp = [0] * (x+1)

for i in range(n):
    hi = h[i]
    si = s[i]
    for j in range(x,hi-1,-1):
        dp[j] = max(dp[j], dp[j-hi] + si)

print(dp[x])