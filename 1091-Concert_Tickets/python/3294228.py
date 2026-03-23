from sys import stdin, stdout
import bisect

def concert_tickets(ticket_price: int, max_customer_price: int) -> int:
    """
    """
    def upper_bound(search_list: list, search: int) -> int:
        low, high = 0, len(search_list)
        while low + 1 < high:
            mid = (low + high) // 2
            if search_list[mid] <= search:
                low = mid
            else:
                high = mid  
        return low + 1

    ticket_price.sort()
    next_avail, i = [i for i in range(len(ticket_price) + 1)], 0
    ticket_purchased = [-1]*len(max_customer_price)
    for idx, ticket in enumerate(max_customer_price):
        index = i = bisect.bisect_right(ticket_price, ticket)
        while i != next_avail[i]:
            i = next_avail[i]
        while index != i:
            next_avail[index], index = i, next_avail[index]
        if i:
            next_avail[i] = i - 1
            ticket_purchased[idx] = ticket_price[i - 1]
    return ticket_purchased

n, m = map(int, input().split())
a, b = [int(x) for x in stdin.readline().split()], [int(x) for x in stdin.readline().split()]
print(*concert_tickets(a, b), sep='\n')
