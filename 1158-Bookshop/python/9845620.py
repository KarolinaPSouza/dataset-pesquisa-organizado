"""
Problem Name: 
Tags: 
Difficulty: 
Problem Statement: 
 Analysis:
- Time complexity: 
- Space complexity: 
- Approach: 
 """

import time


class Solution:
    def get_books(self, n, target, pages, prices):
        dp = [[0] * (target + 1) for _ in range(n + 1)]

        for j in range(1, target + 1):
            for i in range(1, n + 1):
                if j - prices[i - 1] >= 0:
                    dp[i][j] = max(
                        dp[i - 1][j], dp[i - 1][j - prices[i - 1]] + pages[i - 1]
                    )
                else:
                    dp[i][j] = dp[i - 1][j]

        return dp[n][target]

    def get_books_faster(self, n, target, pages, prices):
        dp = [[0] * (target + 1) for _ in range(n + 1)]

        for i in range(1, n + 1):
            page = pages[i - 1]
            cost = prices[i - 1]
            for j in range(1, target + 1):
                if j - cost >= 0:
                    dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - cost] + page)
                else:
                    dp[i][j] = dp[i - 1][j]
        # print(dp)
        return dp[n][target]

    def get_books_1d_faster(self, n, target, pages, prices):
        dp = [0] * (target + 1)
        # dp[j] is the max pages when allowed cost is j. At each iteration we replace it
        # with books allowed till i'th index

        for i in range(1, n + 1):
            page = pages[i - 1]
            cost = prices[i - 1]
            for j in range(target, cost - 1, -1):
                dp[j] = max(dp[j], dp[j - cost] + page)

        return dp[target]


if __name__ == "__main__":

    [n, target] = list(map(int, input().split()))
    prices = list(map(int, input().split()))
    pages = list(map(int, input().split()))
    sol = Solution()
    # print(sol.get_books(n, target, pages, prices))

    # # Start timing get_books_faster
    # start_time = time.time()
    # print(sol.get_books(n, target, pages, prices))
    # end_time = time.time()
    # print(f"get_books took {end_time - start_time} seconds.")

    # # Start timing get_books_faster
    # start_time = time.time()
    # print(sol.get_books_faster(n, target, pages, prices))
    # end_time = time.time()
    # print(f"get_books_faster took {end_time - start_time} seconds.")

    # Start timing get_books_faster
    # start_time = time.time()
    print(sol.get_books_1d_faster(n, target, pages, prices))
    # end_time = time.time()
    # print(f"get_books_1d_faster took {end_time - start_time} seconds.")

    # # Start timing get_books_1d
    # start_time = time.time()
    # print(sol.get_books_1d(n, target, pages, prices))
    # end_time = time.time()
    # print(f"get_books_1d took {end_time - start_time} seconds.")