def right_search(arr, x):
    left_1 = -1
    right_1 = len(arr)
    while right_1 - left_1 > 1:
        middle = (right_1 + left_1) // 2
        if arr[middle] <= x:
            left_1 = middle
        else:
            right_1 = middle
    return right_1

def projects(n: int, arr: list) -> int:
    starts = [arr[i][0] for i in range(n)]
    ends = [arr[i][1] for i in range(n)]
    rewards = [arr[i][2] for i in range(n)]
    dp = [0] * n
    dp[0] = rewards[0]
    for i in range(1,n):
        pos = right_search(ends, starts[i] - 1)
        if pos > 0:
            val = dp[pos-1] + rewards[i]
        else:
            val = rewards[i]
        dp[i] = max(val, dp[i-1])
    return dp[n-1]

n = int(input())
arr = []
for i in range(n):
    arr.append([int(i) for i in input().split()])
print(projects(n, sorted(arr, key=lambda x: x[1])))