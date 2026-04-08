import sys
from bisect import bisect_left, bisect_right


def input_processor():
    input = sys.stdin.readline

    n, x = list(map(int, input().split()))
    arr = list(map(int, input().split()))

    return n, x, arr


def subset_sum(arr, lim):
    sums = [0]

    for val in arr:
        if val > lim:
            continue
        adds = [val + s for s in sums if val + s <= lim]

        if adds:
            sums += adds
    return sums


def solve(n, x, arr):
    mid = n // 2
    left_arr, right_arr = arr[:mid], arr[mid:]
    res = 0

    left_sum = subset_sum(left_arr, x)
    right_sum = subset_sum(right_arr, x)
    right_sum.sort()
    left_sum.sort()

    # Binary search: ~ O(2^{n//2} x log_2(2^{n//2})) -> TLE
    # for s in left_sum:
    #     res += bisect_right(right_sum, x - s) - bisect_left(right_sum, x - s)

    # Two-pointer technique: ~ O(2^{n//2})
    left = 0
    right = len(right_sum) - 1

    while left < len(left_sum) and right >= 0:
        s = left_sum[left] + right_sum[right]
        if s == x:
            next_left = left + 1
            while next_left < len(left_sum) and left_sum[next_left] == left_sum[left]:
                next_left += 1

            next_right = right - 1
            while next_right >= 0 and right_sum[next_right] == right_sum[right]:
                next_right -= 1

            res += (next_left - left) * (right - next_right)
            left = next_left
            right = next_right

        elif s > x:
            right -= 1
        else:
            left += 1

    print(res)


if __name__ == "__main__":
    n, x, arr = input_processor()
    solve(n, x, arr)