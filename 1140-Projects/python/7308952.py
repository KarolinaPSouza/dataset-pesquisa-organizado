from bisect import bisect_left
n = int(input())
mod = 10**6
a,b,p = [0]*n,[0]*n,[0]*n
for i in range(n):
    a[i],b[i],p[i] = map(int,input().split())
dp = [0]
sb = sorted(i+mod*v for i,v in enumerate(b))
for x in sb:
    dp.append(max(dp[-1],dp[bisect_left(sb,mod*a[x % mod])]+p[x % mod]))
print(dp[n])