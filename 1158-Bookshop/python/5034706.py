import sys
input = sys.stdin.readline

############ ---- Input Functions ---- ############
inp = sys.stdin.readline
def input(): return inp().strip()
def ii(): return int(input())
def mi(): return map(int, input().split())
def li(): return list(map(int, input().split()))


def solve():
    n, totalPrice = mi()

    price = li()
    numberOfPage = li()

    # @lru_cache(None)
    # def dp(currPrice, index):
    #     if index == n or currPrice <= 0:
    #         return 0
    #     take = 0
    #     if currPrice-price[index] >= 0:
    #         take = dp(currPrice-price[index], index+1) + numberOfPage[index]
    #     dontake = dp(currPrice, index+1)
    #     return max(take, dontake)

    dp = [0 for i in range(totalPrice+1)]

    for index in range(n):
        currPrice = price[index]
        for money in range(totalPrice, currPrice-1, -1):
            dp[money] = max(
                dp[money], dp[money-currPrice]+numberOfPage[index])
    return dp[totalPrice]


def main():
    print(solve())


if __name__ == '__main__':
    main()