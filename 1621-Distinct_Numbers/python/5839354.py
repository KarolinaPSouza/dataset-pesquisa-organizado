n = int(input())
values = list(map(int, input().split()))
values.sort()
answer = 1
for i in range(1, n):
    if values[i] != values[i-1]:
        answer += 1
print(answer)