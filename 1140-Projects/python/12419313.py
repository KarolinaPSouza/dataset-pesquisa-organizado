def binary_search(i, starts, ends):
    l, r = 0, i - 1
    res = -1
    while l <= r:
        m = l + (r - l)//2
        if ends[m] < starts[i]:
            res = m 
            l = m + 1
        else:
            r = m - 1
    return res

def max_reward(n, projects: list):
    projects.sort(key=lambda ele: ele[1])
    starts = [proj[0] for proj in projects]
    ends = [proj[1] for proj in projects]
    rewards = [proj[2] for proj in projects]
    dp = [0]*n
    for i in range(n):
        if i > 0:
            dp[i] = dp[i-1] 
        prev = binary_search(i, starts, ends)
        if prev != -1:
            dp[i] = max(dp[i], rewards[i] + dp[prev])
        else:
            dp[i] = max(dp[i], rewards[i])
    return dp[-1]

if __name__ == "__main__":
    n = int(input())
    projects = []
    for _ in range(n):
        projects.append(list(map(int, input().split(" "))))
    print(max_reward(n, projects))