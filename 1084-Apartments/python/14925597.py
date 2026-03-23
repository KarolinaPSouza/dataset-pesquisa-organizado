import sys

input = sys.stdin.read
data = input().split()

n = int(data[0])
m = int(data[1])
k = int(data[2])
a = list(map(int, data[3:3+n]))
b = list(map(int, data[3+n:]))

a.sort()
b.sort()

i = 0
j = 0
count = 0

while i < n and j < m:
    if a[i] - k <= b[j] <= a[i] + k:
        count += 1
        i += 1
        j += 1
    elif b[j] < a[i] - k:
        j += 1
    else:
        i += 1

print(count)