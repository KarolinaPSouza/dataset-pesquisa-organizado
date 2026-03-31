n = int(input())
starts = []
ends = []

for _ in range(n):
    a, b = map(int, input().split())
    starts.append(a)
    ends.append(b)

starts.sort()
ends.sort()

i = j = 0
curr = ans = 0

# Sweep line: compare starts and ends
while i < n and j < n:
    if starts[i] < ends[j]:
        curr += 1
        ans = max(ans, curr)
        i += 1
    else:
        curr -= 1
        j += 1

print(ans)