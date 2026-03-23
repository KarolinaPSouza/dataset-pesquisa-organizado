n, m, k = [int(x) for x in input().split()]
needs = [int(x) for x in input().split()]
have = [int(x) for x in input().split()]

needs.sort()
have.sort()
count = 0
i, j = 0, 0
# print(needs, have)
while i < n and j < m:
  if have[j] < needs[i] - k:
    j += 1
  elif have[j] > needs[i] + k:
    i += 1
  else:
    i += 1
    j += 1
    count += 1
print(count)