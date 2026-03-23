n, m, k = map(int, input().split())

applicants = sorted(list(map(int, input().split())))
appartments = sorted(list(map(int, input().split())))

i = 0
count = 0
for a in applicants:
  while i < m and appartments[i] < a - k:
    i += 1
  if i < m and appartments[i] <= a + k:
    count += 1
    i += 1
  if i >= m:
    break
print(count)