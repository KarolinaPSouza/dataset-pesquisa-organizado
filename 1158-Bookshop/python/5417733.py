def solve():
    memo = [0]*(maxP+1)

    for p, g in zip(prices, pages):
        for i in range(maxP, p-1, -1):
            memo[i] = max(memo[i], g+memo[i-p])

    return memo[-1]

N, maxP = map(int, input().split())
prices = list(map(int, input().split()))
pages = list(map(int, input().split()))

print(solve())