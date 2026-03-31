import sys

read = sys.stdin.readline  # alias for fast input

# parse input
n = int(read())
a = list(map(int, read().split()))
a.sort()

ans = 1
for i in range(1, n):
    if a[i] != a[i - 1]:
        ans += 1

print(ans)