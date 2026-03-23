num = list(map(int, input().split()))
s_g = list(map(int, input().split()))
s_w = list(map(int, input().split()))
k = num[-1]

s_g.sort()
s_w.sort()

res = 0
i = j = 0

while i < len(s_g) and j < len(s_w):
    if abs(s_g[i] - s_w[j]) <= k:
        res += 1
        i += 1
        j += 1
    elif s_w[j] < s_g[i] - k:
        j += 1
    else:
        i += 1

print(res)