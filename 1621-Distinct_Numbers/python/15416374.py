import sys

n = int(sys.stdin.readline())
arr = list(map(int, sys.stdin.readline().split()))
arr.sort()

ans = 1
for i in range(n - 1):
    if arr[i] != arr[i + 1]:
        ans += 1

print(ans)