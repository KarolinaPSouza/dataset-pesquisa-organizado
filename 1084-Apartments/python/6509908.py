n, m, k = map(int, input().split())
desired = list(map(int, input().split()))
apartments = list(map(int, input().split()))

desired.sort()
apartments.sort()

placed = 0
i = 0
j = 0

while i < n and j < m:
  if abs(desired[i] - apartments[j]) <= k:
    placed += 1
    i += 1
    j += 1
  elif desired[i] < apartments[j]:
    i += 1
  else:
    j += 1

print(placed)