import sys
input = lambda: sys.stdin.readline().rstrip("\r\n")
sint = lambda: int(input())
mint = lambda: map(int, input().split())
aint = lambda: list(map(int, input().split()))
###############################################
n,x=mint()
dp=[0]*(x+1)
h=aint()
s=aint()
for i in range(n):
    hi,si=h[i],s[i]
    for j in range(x,hi-1,-1):
        dp[j]=max(dp[j],dp[j-hi]+si)
print(dp[x])