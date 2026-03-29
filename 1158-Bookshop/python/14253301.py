import sys

# # Remove these two lines while submitting online
# sys.stdin = open('input.txt', 'r')
# sys.stdout = open('output.txt', 'w')

n, x = map(int, input().split())
prices = list(map(int, input().split()))
pages = list(map(int, input().split()))

dp = [0] * (x + 1)

for i in range(n):
    p, pg = prices[i], pages[i]
    for j in range(x, p - 1, -1):
        if dp[j - p] + pg > dp[j]:
            dp[j] = dp[j - p] + pg

print(dp[x])