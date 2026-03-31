import sys

data = list(map(int, sys.stdin.buffer.read().split()))
n = data[0]

# arrivals: a1, a2, ..., an
# departures: b1, b2, ..., bn
arr = data[1:2*n+1:2]
dep = data[2:2*n+2:2]

arr.sort()
dep.sort()

i = j = 0
cur = ans = 0

# all times are distinct -> no need to handle equality specially
while i < n and j < n:
    if arr[i] < dep[j]:
        cur += 1
        if cur > ans:
            ans = cur
        i += 1
    else:
        cur -= 1
        j += 1

sys.stdout.write(str(ans))