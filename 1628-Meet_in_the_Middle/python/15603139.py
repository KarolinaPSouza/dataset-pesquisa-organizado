import sys

def solve():
    input_data = sys.stdin.read().split()

    if not input_data:
        return

    n = int(input_data[0])
    x = int(input_data[1])
    t = [int(val) for val in input_data[2:]]

    mid = n // 2
    left_part = t[:mid]
    right_part = t[mid:]

    def get_subset_sums(arr):
        sums = {0: 1} # base case: sum 0 is possible in 1 way

        for num in arr:
            current_items = list(sums.items())
            for s, count in current_items:
                new_sum = s + num

                if new_sum <= x:
                    sums[new_sum] = sums.get(new_sum, 0) + count

        return sums

    left_sums = get_subset_sums(left_part)
    right_sums = get_subset_sums(right_part)

    ans = 0

    for s_left, count_left in left_sums.items():
        needed = x - s_left
        if needed in right_sums:
            ans += count_left * right_sums[needed]

    print(ans)


if __name__ == '__main__':
    solve()
