from collections import defaultdict
from bisect import bisect, bisect_left

# dict A that stores the projects
# A [end day] = list of (start, reward)

OOF = 10**10  # oof size large
n = int(input())
projects = defaultdict(dict)
for _ in range(n):
    a, b, p = map(int, input().split())
    projects[b][a] = max(projects[b].get(a,0), p)

# add some index remapping shit so that u can just do A[start-1] instead of
# like sorting it again or some gay shit

to_day = sorted(projects.keys())
to_index = {end: i for i, end in enumerate(to_day)}
A = [0]*len(projects)

for i, end in enumerate(to_day):
    A[i] = A[i-1]
    for start in sorted(projects[end]):
        reward = projects[end][start]
        # print(start, end, reward, A[to_index[end]], to_day[bisect_left(to_day, start)-1])
        A[to_index[end]] = max(A[to_index[end]], A[bisect_left(to_day, start)-1] + reward)
        # print(A)
    # start = 0
    # while True:
        # ends = projects[end]
        # index = bisect(ends, (start, OOF))
        # if ends[index][0] != start:
            # break
        # index -= 1
        # start = ends[index][0]
        # new = A.setdefault(start-1,0) + ends[index][1]
        # A[end] = max(A[end], new)
        # start = ends[max(len(ends)-1,index+1)][0]
print(A[-1])

'''
10
14 14 98
76 76 58
94 94 57
92 92 45
82 82 14
86 86 41
87 87 72
14 14 26
27 27 85
48 48 52
'''