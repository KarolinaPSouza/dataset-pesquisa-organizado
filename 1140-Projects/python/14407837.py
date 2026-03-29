import sys

n = int(sys.stdin.readline())
a, b, p = [], [], []

# Step 1: read input and collect coordinates
coords = set()
for _ in range(n):
    ai, bi, pi = map(int, sys.stdin.readline().split())
    bi += 1                     # note the "+1" like in C++
    a.append(ai)
    b.append(bi)
    p.append(pi)
    coords.add(ai)
    coords.add(bi)

# Step 2: coordinate compression
sorted_coords = sorted(coords)
compress = {v: i for i, v in enumerate(sorted_coords)}

# Step 3: group projects by their end coordinate
projects = [[] for _ in range(len(compress))]
for i in range(n):
    projects[compress[b[i]]].append((compress[a[i]], p[i]))

# Step 4: DP over compressed coordinates
dp = [0] * len(compress)
for i in range(len(compress)):
    if i > 0:
        dp[i] = dp[i-1]  # carry forward best result
    for start, profit in projects[i]:
        dp[i] = max(dp[i], dp[start] + profit)

print(dp[-1])
