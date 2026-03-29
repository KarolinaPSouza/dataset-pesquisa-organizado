# Input processing
n = int(input())  # Number of projects
a = []
b = []
p = []
compress = {}

# Step 1: Input the values and collect all coordinates to compress
for i in range(n):
    x, y, profit = map(int, input().split())
    a.append(x)
    b.append(y + 1)  # Increment b to account for inclusive range [a, b)
    p.append(profit)
    compress[a[i]] = 0  # Register the start coordinate
    compress[b[i]] = 0  # Register the end coordinate

# Step 2: Assign compressed indices to the coordinates
coords = 0
for key in sorted(compress.keys()):
    compress[key] = coords
    coords += 1

# Step 3: Create a project list using the compressed coordinates
project = [[] for _ in range(coords)]  # Create empty lists for each compressed coordinate

for i in range(n):
    # Map the original coordinates a[i] and b[i] to their compressed values
    project[compress[b[i]]].append((compress[a[i]], p[i]))
# print(project)
# Step 4: Initialize a DP array to store the maximum profit up to each compressed time
dp = [0] * coords

# Step 5: Perform the dynamic programming calculation
for i in range(coords):
    if i > 0:
        dp[i] = dp[i - 1]  # Carry forward the max profit from the previous coordinate
    for start, profit in project[i]:
        dp[i] = max(dp[i], dp[start] + profit)  # Update the DP table

# Output the result: maximum profit achievable
print(dp[coords - 1])