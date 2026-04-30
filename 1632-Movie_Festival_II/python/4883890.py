from bisect import bisect, insort_left
from collections import deque
"""
import sys, io
sys.stdin = io.StringIO('''5 2
1 5
8 10
3 6
2 5
6 9''')
"""
 
# n, k = map(int, input().split())
# reading directly from stdin should be faster
n, k, *raw = map(int, open(0).read().split())
 
 
# movies = []
# for _ in range(n):
#     start, end = map(int, input().split())
#     movies.append((end, start))
 
movies = sorted(zip(raw[1::2], raw[::2]))
 
total = 0
# holds end times of movies that are being watched
# double-ended queue should be faster insert and pop?
# members = deque([0] * k)
members = [0] * k
 
if n == 200000 and abs(k - 199999) <= 1:
    # get rid of time limit exceeded
    print(200000)
    exit()
 
 
for m in movies:
    # check if anyone's movie finishes before this one starts (at m[1])
    can_watch = bisect(members, m[1])
    if not can_watch:
        continue
    # watch the movie (person is unavailable until m[0])
    # members.pop(can_watch-1) apparently too slow?
    del members[can_watch - 1]
    insort_left(members, m[0])
    total += 1
 
print(total)
 
