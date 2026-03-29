import bisect
n = int(input())
arr = []
for i in range(n):
    arr.append(list(map(int , input().split())))
arr.sort(key = lambda x : x[1])
end = [i[1] for i in arr]
dp = [0] * (n + 1)
for i in range(1 , n + 1):
    start , e , reward = arr[i - 1]
    ind = bisect.bisect_right(end , start - 1)
    dp[i] = max(dp[i - 1] , dp[ind] + reward)
print(dp[n])
