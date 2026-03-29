from bisect import bisect_left
from collections import defaultdict
import sys
input = sys.stdin.read

def solve():
    data = input().split()
    n = int(data[0])
    events = []
    projects = []

    idx = 1
    for _ in range(n):
        x = int(data[idx])
        y = int(data[idx+1]) + 1  # To handle end+1 as in the original code
        z = int(data[idx+2])
        projects.append((x, y, z))
        events.append(x)
        events.append(y)
        idx += 3

    # Coordinate compression
    events = sorted(set(events))
    comp = {event: i for i, event in enumerate(events)}

    # DP array and project mapping
    dp = [0] * (len(events) + 1)
    proj = defaultdict(list)

    for x, y, z in projects:
        proj[comp[y]].append((comp[x], z))

    # Dynamic Programming to calculate the maximum reward
    for i in range(len(events)):
        if i > 0:
            dp[i] = dp[i-1]
        for st, rew in proj[i]:
            dp[i] = max(dp[i], dp[st] + rew)

    print(dp[len(events) - 1])

if __name__ == "__main__":
    solve()