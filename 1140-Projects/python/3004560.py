n = int(input())
A = []
B = []
P = []
times = []
close = {}
for i in range(n):
    a, b, p = [int(i) for i in input().split()]
    A.append(a)
    B.append(b+1)
    P.append(p)
    times.append(a)
    times.append(b+1)

times = sorted(list(set(times)))
mp = {}
for i in range(len(times)):
    mp[times[i]] = i

close = dict()
for i in range(n):
    eff_b = mp[B[i]]
    if eff_b not in close:
        close[eff_b] = []
    close[eff_b].append([mp[A[i]], P[i]])

dp = [0 for i in range(len(times)+1)]

for i in range(len(times)+1):
    dp[i] = dp[i-1]
    if i not in close:
        continue
    for j, pi in close[i]:
        #print(j, pi, close[i])
        if j == 0:
            dp[i] = max(dp[i], pi)
            continue
        dp[i] = max(dp[j] + pi, dp[i])
print(dp[-1])