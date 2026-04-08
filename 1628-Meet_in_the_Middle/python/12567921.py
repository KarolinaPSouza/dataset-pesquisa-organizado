from collections import Counter
import sys

def gen_subset_sums(arr):
    sums = [0]
    for x in arr:
        # Using list concatenation with a list comprehension is efficient since the comprehension is in C.
        sums += [s + x for s in sums]
    return sums

data = sys.stdin.read().split()
n = int(data[0])
target = int(data[1])
nums = list(map(int, data[2:]))

# Split the array into two halves.
left_nums = nums[:n//2]
right_nums = nums[n//2:]

left_sums = gen_subset_sums(left_nums)
right_sums = gen_subset_sums(right_nums)

# Instead of sorting and binary searching, count frequencies of each subset sum in the right half.
right_counter = Counter(right_sums)

result = 0
for s in left_sums:
    # For each left sum, add the count of right sums that would bring the total to target.
    result += right_counter[target - s]

sys.stdout.write(str(result))