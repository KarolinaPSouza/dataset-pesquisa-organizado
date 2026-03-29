def max_reward(n, projects):
    projects.sort(key=lambda x: x[1])

    dp = [0] * (n + 1)

    def binary_search(start):
        low, high = 0, n - 1
        while low <= high:
            mid = (low + high) // 2
            if projects[mid][1] < start:
                low = mid + 1
            else:
                high = mid - 1
        return high

    for i in range(1, n + 1):
        a_i, b_i, p_i = projects[i - 1]

        j = binary_search(a_i) + 1

        dp[i] = max(dp[i - 1], dp[j] + p_i)


    return dp[n]


import sys
input = sys.stdin.read
data = input().split()
n = int(data[0])
projects = [(int(data[i]), int(data[i+1]), int(data[i+2])) for i in range(1, len(data), 3)]

print(max_reward(n, projects))