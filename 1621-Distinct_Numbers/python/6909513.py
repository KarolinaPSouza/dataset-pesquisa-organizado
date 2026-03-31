n = int(input())

numbers = sorted(map(int, input().split()))
ans = 1
for i in range(1, n):
 if numbers[i] != numbers[i - 1]:
  ans += 1
print(ans)