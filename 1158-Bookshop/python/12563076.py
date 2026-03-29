from sys import stdin, stdout


def input():
    return stdin.readline().strip()


n, x = map(int, input().split())
price = list(map(int, input().split()))
pages = list(map(int, input().split()))
dp = [0] * (x + 1)

for h, s in zip(price, pages):
    for i in range(x, h - 1, -1):
        dp[i] = max(dp[i], dp[i - h] + s)


stdout.write(f"{dp[x]}")