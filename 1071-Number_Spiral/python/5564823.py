# number hell

t = int(input())
nums = []

for i in range(t):
  lis = input().split(" ")
  y = int(lis[0])
  x = int(lis[1])
  max_l = max(y, x)
  if y == x:
    num = max_l ** 2 - (max_l - 1)
  elif max_l % 2 == 0:
    if max_l == y:
      num = max_l ** 2 - (x - 1)
    else:
      num = (max_l - 1) ** 2 + y
  else:
    if max_l == x:
      num = max_l ** 2 - (y - 1)
    else:
      num = (max_l - 1) ** 2 + x
  nums.append(num)

for j in range(len(nums)):
  print(str(nums[j]))