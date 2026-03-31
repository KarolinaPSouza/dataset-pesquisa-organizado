import sys

data = sys.stdin.buffer.read().split()
if not data:
    sys.exit(0)

n = int(data[0])

arrivals = [0] * n
leavings = [0] * n

idx = 1
for i in range(n):
    a = int(data[idx])
    b = int(data[idx + 1])
    idx += 2
    arrivals[i] = a
    leavings[i] = b

arrivals.sort()
leavings.sort()

i = j = 0
cur = 0
best = 0

# all arrival/leaving times are distinct, so no equality case
while i < n and j < n:
    if arrivals[i] < leavings[j]:
        cur += 1
        if cur > best:
            best = cur
        i += 1
    else:
        cur -= 1
        j += 1

sys.stdout.write(str(best))