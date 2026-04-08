n, target = map(int, input().split())
nums = list(map(int, input().split()))

def get_subset_sums(arr):
    # Start with a sum of 0 occurring once
    sums = {0: 1}
    for x in arr:
        new_sums = sums.copy()
        for s, count in sums.items():
            new_s = s + x
            if new_s <= target:
                new_sums[new_s] = new_sums.get(new_s, 0) + count
        sums = new_sums
    return sums

# Get frequency maps for both halves
left_sum_frequencies = get_subset_sums(nums[:n // 2])
right_sum_frequencies = get_subset_sums(nums[n // 2:])

total_count = 0

# Iterate through one dictionary and check the complement in the other
for s_left, count_left in left_sum_frequencies.items():
    needed = target - s_left
    if needed in right_sum_frequencies:
        total_count += count_left * right_sum_frequencies[needed]

print(total_count)