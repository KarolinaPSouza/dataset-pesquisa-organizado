n = int(input())
nums = list(map(int, input().split()))

nums.sort()

distinct = 1
for i in range(1, len(nums)):
    if nums[i] != nums[i-1]:
        distinct += 1

print(distinct)