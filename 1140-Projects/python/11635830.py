from bisect import bisect_left as bsl
import sys
inp = [*map(int, open(0).read().split())]
n=inp[0]
a,b,p = zip(*sorted(((a, b, c) for a, b, c in zip(*[iter(inp[1:])]*3)),key=lambda x:x[1]))
dp=[0]*(n+1)
for i in range(n):
    x=bsl(b,a[i])
    dp[i+1]=max(dp[i],dp[x]+p[i])
print(dp[-1])