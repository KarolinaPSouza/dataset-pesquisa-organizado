n = int(input())
starts = []
ends = []

for _ in range(n):
    a, b = map(int, input().split())
    starts.append(a)
    ends.append(b)

starts.sort()
ends.sort()

ans = 0
cnt = 0
i = j = 0

while i < n:
    if starts[i] <= ends[j]:
        cnt += 1
        ans = max(ans, cnt)
        i += 1
    else:
        cnt -= 1
        j += 1

print(ans)