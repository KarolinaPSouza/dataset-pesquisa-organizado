# n=int(input())
# arr=[list(map(int,input().split())) for _ in range(n)]
# arr,dp=sorted(arr,key=lambda x:x[1]),[[0,0] for _ in range(n+1)]
# for i in range(1,n+1):
#     start,end,b=0,i,arr[i-1]
#     tar=b[0]
#     while start<end:
#         mid=start+(end-start)//2
#         if dp[mid][1]>=tar:
#             end=mid
#         else:
#             start=mid+1
#     a=dp[i-1]
#     if a[0]>b[2]+dp[start-1][0]:
#         dp[i][0]=a[0]
#         dp[i][1]=a[1]
#     else:
#         dp[i][0]=b[2]+dp[start-1][0]
#         dp[i][1]=b[1]
# print(dp[n][0])
import sys
input = sys.stdin.read
output = sys.stdout.write
data = input().splitlines()
n = int(data[0])
arr = [list(map(int, line.split())) for line in data[1:n+1]]
arr = sorted(arr, key=lambda x: x[1])
dp = [[0, 0] for _ in range(n+1)]
for i in range(1, n+1):
    start, end, b = 0, i, arr[i-1]
    tar = b[0]
    while start < end:
        mid = start + (end - start) // 2
        if dp[mid][1] >= tar:
            end = mid
        else:
            start = mid + 1
    a = dp[i-1]
    if a[0] > b[2] + dp[start-1][0]:
        dp[i][0] = a[0]
        dp[i][1] = a[1]
    else:
        dp[i][0] = b[2] + dp[start-1][0]
        dp[i][1] = b[1]
output(f"{dp[n][0]}\n")