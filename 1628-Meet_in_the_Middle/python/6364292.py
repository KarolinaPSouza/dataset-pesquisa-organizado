from collections import Counter

_, target_sum = map(int, input().split())
nums = list(map(int, input().split()))

def subset_sums_in(arr: list) -> list:
    sums = [0]
    for num in arr:
        sums += [cur + num for cur in sums]
    return sums

l_cnt, r_cnt = Counter(subset_sums_in(nums[:len(nums) // 2])), Counter(subset_sums_in(nums[len(nums) // 2:]))

valid_cnt = 0

for l_sum, freq in l_cnt.items():
    valid_cnt += freq * r_cnt.get(target_sum - l_sum, 0)

print(valid_cnt)