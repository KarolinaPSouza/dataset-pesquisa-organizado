#cses book shop
#0/1 knapsack variation 
def main():
    #  Read inputs
    n, x = map(int, input().split())
    prices = list(map(int, input().split()))
    pages = list(map(int, input().split()))

    # Initialize DP array
    dp = [0] * (x + 1)

    # checking each book 
    for i in range(n):
        price = prices[i]
        page = pages[i]
        for j in range(x, price - 1, -1):
            dp[j] = max(dp[j], dp[j - price] + page)

    # Output result
    print(max(dp))

if __name__ == "__main__":
    main()