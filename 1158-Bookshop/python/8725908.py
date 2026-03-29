n, total_amount = list(map(int,input().split()))
book_prices = list(map(int,input().split()))
book_pages = list(map(int,input().split()))


prev_row = [0 for _ in range(total_amount + 1)]
curr_row = [0 for _ in range(total_amount + 1)]

for end_index in range(n):
 current_price = book_prices[end_index]
 pages = book_pages[end_index]
 for amount in range(book_prices[end_index],total_amount+1):
  curr_row[amount] = max(prev_row[amount-current_price] +pages,prev_row[amount])
 prev_row = curr_row.copy()



print(prev_row[-1])