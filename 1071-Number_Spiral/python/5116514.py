t = int(input())
nums = []
for i in range(t):
    y, x = map(int, input().split())
    num = 0
    if max(y, x) % 2 == 0:
        diff = abs(max(y, x) - y) + abs(1 - x)
    else:
        diff = abs(1 - y) + abs(max(y, x) - x)
    num = max(y, x) ** 2 - diff
    nums.append(num)
for num in nums:
    print(num)

