import bisect

n = int(input())
P = []
for _ in range(n):
    P.append(list(map(int,input().split())))

P.sort(key=lambda x:x[0])
S = [x[0] for x in P]


dp = [0]*(n+1)
for i in range(n-1,-1,-1):
    j = bisect.bisect_left(S,P[i][1]+1)
    dp[i] = max(P[i][-1] + dp[j], dp[i+1])

print(dp[0])