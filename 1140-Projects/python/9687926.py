from bisect import bisect_right
import sys
input = sys.stdin.readline

n = int(input())
arr = [list(map(int, input().split())) for _ in range(n)]
arr.sort(key=lambda x: (x[1]))

start = list(map(lambda x: x[0], arr))
finish = list(map(lambda x: x[1], arr))
dp=[0]*(n+1)
dp[0] = arr[0][2]

for i in range(1, n):
    id = bisect_right(finish, start[i]-1)
    if id>0:
        p = dp[id-1]+arr[i][2]
    else:
        p = arr[i][2]
    dp[i] = max(dp[i-1], p)
print(dp[n-1])