def maximum_number_pages(x, n, books):
    max_pages = [0] * (x + 1)
    books.sort()
    for price, count in books:
        for i in range(x, price - 1, -1):
            max_pages[i] = max(max_pages[i], max_pages[i - price] + count)
    return max_pages[x]


n, x = map(int, input().split())
prices = list(map(int, input().split()))
number_pages = list(map(int, input().split()))
books = list(zip(prices, number_pages))

print(maximum_number_pages(x, n, books))

"""
# DP Solution: TLE
def maximum_number_pages(x, n, books):
    max_pages = [array.array('L', [0] * (x + 1)) for _ in range(n + 1)]
    books.sort()
    for i in range(1, n + 1):
        for j in range(x + 1):
            max_pages[i][j] = max_pages[i-1][j]
            if books[i - 1][0] <= j:
                max_pages[i][j] = max(
                    max_pages[i - 1][j],
                    max_pages[i - 1][j - books[i - 1][0]] + books[i - 1][1])
    return max_pages[n][x]
"""