import sys
n = int(sys.stdin.readline())
arr= list(map(int,sys.stdin.readline().split()))
arr.sort()
count = 1
for i in range(1, n):
    if arr[i] != arr[i - 1]:
        count += 1

print(count)