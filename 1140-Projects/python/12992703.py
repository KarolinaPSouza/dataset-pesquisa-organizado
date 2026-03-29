import bisect
import sys 
input = sys.stdin.readline
n = int(input())
projects = []
for _ in range(n):
    projects.append([int(i) for i in input().split()])
projects.sort(key = lambda x : x[1])
ends = [b for a,b,c in projects]
dp = [0] * n 
dp[0] = projects[0][2]
def binary_search(l,r,t,ends):
    while l < r:
        m = (l + r)//2 
        if ends[m] >= t:
            r = m  
        else:
            l = m + 1
    if ends[l] < t:
        return l 
    return l - 1

for i in range(1,n):
    l = binary_search(0,i - 1, projects[i][0], ends)
    if l != -1:
        dp[i] = max(dp[i - 1], projects[i][2] + dp[l])
    else:
        dp[i] = max(dp[i - 1], projects[i][2])
print(dp[-1])