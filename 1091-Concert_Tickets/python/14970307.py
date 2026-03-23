import collections

# type rec_list_int = list[int] | list[rec_list_int]


def read_datas():
    n, m = map(int, input().split())
    prices = list(map(int, input().split()))
    customer_max = list(map(int, input().split()))
    return n, m, prices, customer_max


def dicho_simple(goal, start, end, lst):
    if start > end:
        return -1

    left, right = start, end

    while left < right:

        middle = (left + right) // 2
        value = lst[middle]

        if value > goal:
            right = middle - 1

        elif value < goal:
            if left == middle:
                break
            left = middle
        else:
            return middle

    right_value = lst[right]
    left_value = lst[left]

    if right_value <= goal and right_value > left_value:
        return right
    return left


def solve(n, m, prices, customer_maxes):
    prices_counter = collections.Counter(prices)
    available_prices = sorted(prices_counter.keys())
    prev_available = [[i] for i in range(len(available_prices))]
    k = len(available_prices)
    final_prices = [-1] * m

    for i in range(m):
        customer_max_price = customer_maxes[i]

        nearest_index = dicho_simple(customer_max_price, 0, k - 1, available_prices)
        nearest_found = available_prices[nearest_index]

        if nearest_index < 0 or nearest_found > customer_max_price:
            # no price was found
            final_prices[i] = -1
            continue

        if prices_counter[nearest_found] == 0:
            # find the next available
            prev = prev_available[nearest_index]
            while isinstance(prev[0], list):
                prev = prev[0]
            final = prev

            # update the previous nodes
            old = prev_available[nearest_index]
            while old != final:
                next = old[0]
                old[0] = final
                old = next

            # retrieve the actual values
            nearest_index = final[0]
            nearest_found = available_prices[nearest_index]

        if nearest_index < 0:
            # no price is available
            final_prices[i] = -1
            continue

        final_prices[i] = nearest_found
        prices_counter[nearest_found] -= 1

        if prices_counter[nearest_found] == 0 and nearest_index > 0:
            # find the next available
            prev = prev_available[nearest_index - 1]
            while isinstance(prev[0], list):
                prev = prev[0]
            prev_available[nearest_index][0] = prev

        elif prices_counter[nearest_found] == 0 and nearest_index == 0:
            prev_available[nearest_index][0] = -1

    return final_prices


def main():
    n, m, prices, customer_max = read_datas()

    final_prices = solve(n, m, prices, customer_max)
    print(*final_prices, sep="\n")


main()