import sys
input = sys.stdin.readline

n, m, k = map(int, (input().split()))
desired = list(sorted(map(int, (input().split()))))
actual = list(sorted(map(int, (input().split()))))

i, j = 0, 0
result = 0

while i < n and j < m:
    if abs(desired[i]-actual[j]) <= k:
        i += 1
        j += 1
        result += 1
    elif desired[i] > actual[j]:
        j += 1
    else:
        i += 1

print(result)