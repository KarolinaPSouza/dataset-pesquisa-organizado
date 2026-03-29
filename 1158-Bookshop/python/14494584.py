def get_max_num_pages(x, book_prices, book_pages):
    dp = [0] * (x + 1)

    for book_price, num_pages in zip(book_prices, book_pages):
        for desired_price in range(x, book_price - 1, -1):
            dp[desired_price] = max(dp[desired_price], num_pages + dp[desired_price - book_price])

    return dp[x]

x = int(input().split(" ")[1])
line_2 = input()
line_3 = input()
book_prices = [int(book_price) for book_price in line_2.split(" ")]
book_pages = [int(num_pages) for num_pages in line_3.split(" ")]
print(get_max_num_pages(x, book_prices, book_pages))