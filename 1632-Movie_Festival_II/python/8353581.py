from __future__ import annotations
from bisect import bisect_left, bisect_right, insort_right
from sys import stdin
 
 
data = stdin.buffer.read().split()
n = int(data[0])
k = int(data[1])
films: list[tuple[int, int]] = []
for i in range(n):
    a = int(data[i * 2 + 2])
    b = int(data[i * 2 + 3])
    films.append((b, a))
films.sort()
SIZE = max(150000, k)
sl: list[list[int]] = [[0] * SIZE for _ in range(k // SIZE)]
maxs = [0] * (k // SIZE)
if k % SIZE != 0:
    sl.append([0] * (k % SIZE))
    maxs.append(0)
 
result = 0
for b, a in films:
    # remove_left
    bucket = max(bisect_right(maxs, a) - 1, 0)
    index = bisect_right(sl[bucket], a)
    if index == 0:
        continue
    guy = sl[bucket].pop(index - 1)
    if not sl[bucket]:
        del sl[bucket]
        del maxs[bucket]
    else:
        maxs[bucket] = max(maxs[bucket], sl[bucket][-1])
 
    result += 1
    # insert
    if len(sl) == 0:
        sl.append([b])
        maxs.append(b)
        continue
    bucket = min(bisect_left(maxs, b), len(sl) - 1)
    insort_right(sl[bucket], b)
    maxs[bucket] = max(maxs[bucket], b)
    if len(sl[bucket]) >= SIZE:
        sl.insert(bucket + 1, sl[bucket][SIZE // 2 :])
        del sl[bucket][SIZE // 2 :]
        maxs.insert(bucket, max(sl[bucket]))
 
 
print(result)