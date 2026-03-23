N = int(input())
M = 10**9+7


def gauss(n):
 return n*(n+1)//2


def range_sum(l, r):
 return gauss(r)-gauss(l-1)


ans = 0
divisor = 1
while divisor<=N:
 count = N//divisor
 end = N//(N//divisor)
 ans += count*range_sum(divisor, end)
 ans %= M
 divisor = end+1

print(ans)