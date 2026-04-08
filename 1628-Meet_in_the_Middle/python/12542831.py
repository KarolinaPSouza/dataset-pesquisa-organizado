def get_sub_sums(nums):
    sub_sums = [0]
    for num in nums:
        sub_sums += [num + s for s in sub_sums]
    return sub_sums

def meet_in_the_middle_count(arr, target):
    n = len(arr)
    left_part, right_part = arr[:n//2], arr[n//2:]

    left_sums = get_sub_sums(left_part)
    right_sums = get_sub_sums(right_part)

    if len(left_sums) > len(right_sums):
        left_sums, right_sums = right_sums, left_sums

    right_count = {}
    for s in right_sums:
        right_count[s] = right_count.get(s, 0) + 1

    count = 0
    for sum_left in left_sums:
        remaining = target - sum_left
        if remaining in right_count:
            count += right_count[remaining]

    return count

n, x = map(int, input().split())
arr = list(map(int, input().split()))[:n]

if sum(arr) < x:
    print(0)
else:
    print(meet_in_the_middle_count(arr, x))