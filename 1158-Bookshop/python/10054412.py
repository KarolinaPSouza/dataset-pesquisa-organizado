from sys import stdin
def input(): return stdin.readline()[:-1]

n, p = map(int, input().split())
price = list(map(int, input().split()))
pages = list(map(int, input().split()))

dp = [0] * (p + 1)
dp[0] = 0
for pri, pag in zip(price, pages):
    for j in range(p, pri - 1, -1):
        dp[j] = max(dp[j], dp[j - pri] + pag)
print(max(dp))