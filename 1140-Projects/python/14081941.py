from bisect import bisect_right

def rec(lo, prev_end):
    if lo >= n:
        return 0
    if prev_end >= arr[lo][0]:
        return float('-inf')

    not_taken = rec(lo + 1, prev_end)
    taken = 0
    for i in range(lo + 1, n+1):
        taken = max(taken, arr[lo][2] + rec(i, arr[lo][1]))

    return max(taken, not_taken)


def get_pos(idx):
    start = arr[idx][0]

    lo = 0
    hi = i-1
    ans = -1
    while lo <= hi:
        mid = (lo + hi) // 2

        if arr[mid][1] < start:
            ans = mid
            lo = mid + 1
        else:
            hi = mid - 1

    return ans

n = int(input())
arr = []
for _ in range(n):
    arr.append([int(x) for x in input().split()])

arr.sort(key=lambda x: x[1])

# dp = [0 for _ in range(n)]
# dp[i] = max money earned from project 0 to project i, necessarily including project i

# for i in range(n):
#     for j in range(i):
#         if arr[j][1] < arr[i][0]:
#             dp[i] = max(dp[i], arr[i][2] + dp[j])

#     pos = get_pos(i)
#     if pos != -1:
#         dp[i] = max(dp[i], arr[i][2] + dp[pos])

#     dp[i] = max(dp[i], arr[i][2])

# print(max(dp))

# We can't turn the above into less than quadratic
# We need to change the dp definition
# dp[i] = max money earned from projects b/w "time" 0 and i, including i
starts = list(map(lambda x: x[0], arr))
ends = list(map(lambda x: x[1], arr))
rewards = list(map(lambda x: x[2], arr))


dp = [0 for _ in range(n)]
dp[0] = rewards[0]
for i in range(1, n):
    pos = bisect_right(ends, starts[i] - 1)
    if pos > 0:
        taken = dp[pos-1] + rewards[i]
    else:
        taken = rewards[i]

    dp[i] = max(dp[i-1], taken)

print(max(dp))