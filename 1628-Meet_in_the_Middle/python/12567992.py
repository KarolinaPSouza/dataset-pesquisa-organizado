from collections import Counter
import sys

def gen_subset_sums(arr):
    sums = [0]
    for x in arr:
        sums += [s + x for s in sums]
    return sums

data = sys.stdin.read().split()
n = int(data[0])
target = int(data[1])
nums = list(map(int, data[2:]))

left_nums = nums[:n//2]
right_nums = nums[n//2:]

left_sums = gen_subset_sums(left_nums)
right_sums = gen_subset_sums(right_nums)

right_counter = Counter(right_sums)

result = 0
for s in left_sums:
    result += right_counter[target - s]

sys.stdout.write(str(result))