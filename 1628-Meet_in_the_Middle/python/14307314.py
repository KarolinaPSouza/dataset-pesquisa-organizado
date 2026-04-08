from collections import Counter

def solve():
  n, target = list(map(int, input().split()))
  arr = list(map(int, input().split()))

  # dp = [[0 for _ in range(x + 1)] for _ in range(n + 1)]
  # for i in range(n + 1):
  #   dp[i][0] = 1

  # for i in range(1, len(dp)):
  #   for j in range(1, len(dp[0])):
  #     if j - arr[i - 1] >= 0:
  #       dp[i][j] = dp[i - 1][j] + dp[i - 1][j - arr[i - 1]]
  #     else:
  #       dp[i][j] = dp[i - 1][j]
  # print(dp[-1][-1])

  m = (len(arr) // 2) - 1
  arr1 = arr[:m + 1]
  arr2 = arr[m + 1:]

  dp1 = [0]
  for x in arr1:
    dp1 += [x + s for s in dp1]

  dp2 = [0]
  for x in arr2:
    dp2 += [x + s for s in dp2]

  # [0, 2, 3, 5, 2, 4, 5, 7]

  freq2 = Counter(dp2)

  # print(dp1)
  # print(dp2)
  ans = 0
  for i in range(len(dp1)):
    val = dp1[i]
    ans += freq2[target - val]

  # 2  /  3
  # 1 1, 4 4
  # [0, 1, 1, 2], [0, 4, 4, 8]
  print(ans)

  # 2^(n/2)
  # 2, 3,       1, 3, 4

def main():
  solve()

main()