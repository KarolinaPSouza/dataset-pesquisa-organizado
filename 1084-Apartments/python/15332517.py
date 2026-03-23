import sys

enter = sys.stdin.read
val = enter().split()

n = int(val[0])
m = int(val[1])
k = int(val[2])
a = list(map(int, val[3:3+n]))
b = list(map(int, val[3+n:]))

a.sort()
b.sort()

i = 0
j = 0
count = 0

while i < n and j < m:
    if b[j] < a[i] - k:
        j += 1
    elif b[j] > a[i] + k:
        i += 1
    else:
        count += 1
        i += 1
        j += 1

print(count)