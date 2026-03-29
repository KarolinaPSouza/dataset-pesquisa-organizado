import sys
input = sys.stdin.readline

def dp_2_chieu(n, x, h, s):
    dp = [[0] * (x + 1) for _ in range (n + 1)]
    for i in range (1, n + 1):
        for j in range (0, x + 1):
            dp[i][j] = dp[i - 1][j]
            if j >= h[i]:
                dp[i][j] = max(dp[i][j], dp[i - 1][j - h[i]] + s[i])
    return dp[n][x]

def dp_1_chieu(n, x, h, s):
    dp = [0] * (x + 1)
    for i in range (1, n + 1):
        for j in range (x, h[i] - 1, -1):
            dp[j] = max(dp[j], dp[j - h[i]] + s[i])
    return dp[x]

def dp_toi_uu_cses(n, x, h, s):
    dp = [0] * (x + 1)
    # Tối ưu này quan trọng hơn:
    for i in range(1, n + 1):
        hi, si = h[i], s[i]  # Cache values
        for j in range(x, hi - 1, -1):
            new_val = dp[j - hi] + si
            if new_val > dp[j]:  # Avoid max()
                dp[j] = new_val
    return dp[x]

n, x = map(int, input().split())
h = [0] + list(map(int, input().split()))
s = [0] + list(map(int, input().split()))

print(dp_toi_uu_cses(n, x, h, s))

######### DP 1 CHIEU #########

# n=4, x=10
# h = [0, 4, 8, 5, 3]
# s = [0, 5, 12, 8, 1]
# dp = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
#       0  1  2  3  4  5  6  7  8  9  10  ← budget

# Loop 1: j = 10,9,8,7,6,5,4
# dp[j] = max(dp[j], dp[j-4] + 5)
# Before: [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
# After:  [0, 0, 0, 0, 5, 5, 5, 5, 5, 5, 5]
#          0  1  2  3  4  5  6  7  8  9  10

# Loop 2: j = 10,9,8
# dp[j] = max(dp[j], dp[j-8] + 12)
# Before: [0, 0, 0, 0, 5, 5, 5, 5, 5, 5, 5]
# After:  [0, 0, 0, 0, 5, 5, 5, 5, 12, 12, 12]
#          0  1  2  3  4  5  6  7  8   9   10

# Loop 3: j = 10,9,8,7,6,5
# dp[j] = max(dp[j], dp[j-5] + 8)
# j=10: max(12, dp[5]+8) = max(12, 5+8) = 13
# j=9:  max(12, dp[4]+8) = max(12, 5+8) = 13
# j=8:  max(12, dp[3]+8) = max(12, 0+8) = 12
# j=7:  max(5, dp[2]+8)  = max(5, 0+8)  = 8
# j=6:  max(5, dp[1]+8)  = max(5, 0+8)  = 8
# j=5:  max(5, dp[0]+8)  = max(5, 0+8)  = 8
# Before: [0, 0, 0, 0, 5, 5, 5, 5, 12, 12, 12]
# After:  [0, 0, 0, 0, 5, 8, 8, 8, 12, 13, 13]
#          0  1  2  3  4  5  6  7  8   9   10

# Loop 4: j = 10,9,8,7,6,5,4,3
# dp[j] = max(dp[j], dp[j-3] + 1)
# j=10: max(13, dp[7]+1) = max(13, 8+1) = 13
# j=9:  max(13, dp[6]+1) = max(13, 8+1) = 13
# j=8:  max(12, dp[5]+1) = max(12, 8+1) = 12
# j=7:  max(8, dp[4]+1)  = max(8, 5+1)  = 8
# j=6:  max(8, dp[3]+1)  = max(8, 0+1)  = 8
# j=5:  max(8, dp[2]+1)  = max(8, 0+1)  = 8
# j=4:  max(5, dp[1]+1)  = max(5, 0+1)  = 5
# j=3:  max(0, dp[0]+1)  = max(0, 0+1)  = 1
# Before: [0, 0, 0, 0, 5, 8, 8, 8, 12, 13, 13]
# After:  [0, 0, 0, 1, 5, 8, 8, 8, 12, 13, 13]
#          0  1  2  3  4  5  6  7  8   9   10

# Initial: [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
# i=1:     [0, 0, 0, 0, 5, 5, 5, 5, 5, 5, 5]  ← Book 1 thêm vào
# i=2:     [0, 0, 0, 0, 5, 5, 5, 5, 12, 12, 12] ← Book 2 tốt hơn
# i=3:     [0, 0, 0, 0, 5, 8, 8, 8, 12, 13, 13] ← Combo Book 1+3
# i=4:     [0, 0, 0, 1, 5, 8, 8, 8, 12, 13, 13] ← Book 4 ít ảnh hưởng