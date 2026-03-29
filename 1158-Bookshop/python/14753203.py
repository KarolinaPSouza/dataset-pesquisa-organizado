import sys

def get_max_pages(n, budget, prices, pages):
    dp = [0] * (budget+1)
    for j in range(n):
        price, page = prices[j], pages[j]
        for b in range(budget, price-1, -1):
            dp[b] = max(dp[b], dp[b - price] + page)
    return dp[budget]

def main():
    data = list(map(int, sys.stdin.read().split()))
    n, x = data[0], data[1]
    h = data[2:2+n]
    s = data[2+n:2+2*n]
    print(get_max_pages(n, x, h, s))

if __name__ == "__main__":
    main()