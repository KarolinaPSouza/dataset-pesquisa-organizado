t = int(input())

for _ in range(t):
  x, y = [int(x) for x in input().split(' ')]

  if x > y and (x & 1) == 1:
    print(((x - 1) * (x - 1)) + y)
  elif x > y and (x & 1) != 1:
    print((x * x) - (y - 1))
  elif y > x and (y & 1) == 1:
    print((y * y) - (x - 1))
  else:
    print(((y - 1) * (y - 1)) + x)