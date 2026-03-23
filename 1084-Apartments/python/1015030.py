n, m, k = map(int, input().split())
desire = list(map(int, input().split()))
apartment = list(map(int, input().split()))

desire.sort()
apartment.sort()

i=0
j=0
ans = 0

while i < len(desire) and j < len(apartment):
 x = apartment[j]
 if x-k <= desire[i] and desire[i] <= x+k:
  ans += 1
  i += 1
  j += 1
 elif desire[i] > x+k:
  j += 1
 elif desire[i] < x-k:
  i += 1

print(ans)