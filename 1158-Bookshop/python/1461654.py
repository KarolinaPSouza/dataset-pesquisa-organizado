#ans
from sys import stdout,stdin
input = stdin.readline
print = stdout.write
n,x = map(int,input().split())
price = list(map(int,input().split()))
pages = list(map(int,input().split()))

dp = [0]*(x+1)
for h,s in zip(price,pages):
    for j in range(x,h-1,-1):
            dp[j] = max(dp[j],dp[j - h] + s)
print(str(dp[x]))
