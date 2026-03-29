import sys, bisect

n = int(sys.stdin.readline())
intervals = [tuple(map(int, sys.stdin.readline().split()))
             for _ in range(n)]
intervals.sort(key=lambda x: x[1])
ends = [iv[1] for iv in intervals]
dp = [0]*(n+1)

for i in range(1, n+1):
    s, e, w = intervals[i-1]
    j = bisect.bisect_left(ends, s)
    dp[i] = max(dp[i-1], w + dp[j])

print(dp[n])