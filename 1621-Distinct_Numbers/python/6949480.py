input()
nums = input()
numArr = [int(s) for s in nums.split(' ')]
numArr.sort()

n = 1

for i in range(1, len(numArr)):
    if (numArr[i] != numArr[i - 1]):
        n += 1

print(n)