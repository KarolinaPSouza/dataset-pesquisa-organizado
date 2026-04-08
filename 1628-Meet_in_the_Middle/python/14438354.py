n, x = map(int, input().split())
numbers = list(map(int, input().split()))

def calc_subsets(nums):
    m = len(nums)
    sums = [0]
    for i in range(m):
        new_sums = []
        for val in sums:
            new_sums.append(val + nums[i])
        sums += new_sums
    return sums

left = numbers[:n//2]
right = numbers[n//2:]

sums_left = calc_subsets(left)
sums_right = calc_subsets(right)

freq = {}
for v in sums_right:
    freq[v] = freq.get(v, 0) + 1

n_ways = 0
for v in sums_left:
    need = x - v
    if need in freq:
        n_ways += freq[need]

print(n_ways)