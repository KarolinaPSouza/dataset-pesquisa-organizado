import sys
import itertools

def solve(N, X, price, pages):
    dp = [0] * (X + 1)

    for i in range(N):
        p, pg = price[i], pages[i]
        for C in range(X, p - 1, -1):
            dp[C] = max(dp[C], pg + dp[C - p])

    return dp[X]

input = sys.stdin.read
data = input().split()
N = int(data[0])
X = int(data[1])
prices = list(map(int, data[2:N+2]))
pages = list(map(int, data[N+2:2*N+2]))
print(solve(N, X, prices, pages))