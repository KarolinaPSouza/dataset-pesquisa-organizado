n, m, k = [int(num) for num in input().split(' ')]
a = sorted([int(num) for num in input().split(' ')])
b = sorted([int(num) for num in input().split(' ')])

answer = 0
current_j = 0

for i in a:
    for j in range(current_j, len(b)):
        if b[j] > i + k:
            current_j = j
            break
        if i + k >= b[j] and i - k <= b[j]:
            answer += 1
            current_j = j + 1
            break

print(answer)