import sys
sys.setrecursionlimit(1 << 25)

n = int(input())
project = []
for _ in range(n):
    a,b,p = map(int,input().split())
    project.append((a,b,p))
project.sort(key=lambda x:x[1])
ends = [x[1] for x in project]
dp = [0]*(n+1)
def binary_search(arr,s):
    low,high = 0,len(arr)-1
    ans = -1
    while low<=high:
        mid = (low+high)//2
        if arr[mid]<s:
            ans = mid
            low = mid+1
        else:
            high = mid-1
    return ans
for i in range(1,n+1):
    a,b,p = project[i-1]
    ind = binary_search(ends,a)
    if ind != -1:
        take = dp[ind+1]+p
    else:
        take = p
    not_take = dp[i-1]
    dp[i] = max(take,not_take)
print(dp[n])