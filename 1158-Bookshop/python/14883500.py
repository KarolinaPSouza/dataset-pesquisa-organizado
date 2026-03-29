def solve():
    n, x = map(int, input().split())
    prices = list(map(int, input().split()))
    pages = list(map(int, input().split()))
    dp = [0]*(x+1)

    for i in range(n): # iterate through each book
        price = prices[i]
        page = pages[i]
        for j in range(x, price-1, -1):
            dp[j] = max(dp[j], dp[j-price]+ page)
    return dp[x]

if __name__ == "__main__":
    print(solve())