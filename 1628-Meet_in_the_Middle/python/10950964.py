from collections import defaultdict, Counter

n,x = map(int, input().split())
lis = list(map(int, input().split()))

n=len(lis)
lis1 = lis[0:n//2]
lis2 = lis[n//2:]

ans1 = []
ans2 = []

ans1.append(0)
for i in lis1:
    for j in range(0,len(ans1)):
        ans1.append(ans1[j]+i)


ans2.append(0)
for i in lis2:
    for j in range(0,len(ans2)):
        ans2.append(ans2[j]+i)

ans = 0
c1=Counter(ans1)
c2=Counter(ans2)


for key in c1.keys():
    if x-key in c2:
        ans += c1[key]*c2[x-key]
print(ans)


# I once again ask you to try a few more times before referring here
# import sys; input=sys.stdin.buffer.readline

# n, x = map(int, input().split())
# a = list(map(int, input().split()))

# # knapsack
# dp = [0] * (x + 1)
# dp[0] = 1

# for elem in a: # you want this above for knapsack -- this ensures dp_{k}[i] = dp_{k - 1}[i] + dp_{k - 1}[i - elem]
#     for i in range(x, elem - 1, -1): # and reverse here -- 
#         dp[i] += dp[i - elem] 
#     # print(dp)

# print(dp[x])

