import sys
input = sys.stdin.read

# Read all input at once
data = input().splitlines()
n = int(data[0])

cust_time = []

# Parse input more efficiently
for i in range(1, n + 1):
    in_, out = map(int, data[i].split())
    cust_time.append((in_, "I"))
    cust_time.append((out, "O"))

# Sort by time (if times are equal, "O" should come before "I" to handle out first)
cust_time.sort()

count = 0
ans = 0

# Loop over sorted time events
for i in cust_time:
    if i[1] == "I":
        count += 1
        ans = max(ans, count)
    else:
        count -= 1

# Fast output
sys.stdout.write(str(ans) + "\n")