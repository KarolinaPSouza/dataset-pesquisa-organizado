#python 3.7.1
from bisect import bisect_right as b_r
n = int(input())
a = []
for i in range(n): 
  l,r,v = map(int,input().split())
  a.append((l,r,v))
a.sort(key=lambda x:x[1])
start = list(map(lambda x:x[0], a))
end = list(map(lambda x:x[1], a))
value = list(map(lambda x:x[2], a))
dp = [0]*n
#dp[i] max money u can earn until project i
dp[0] = value[0]
for i in range(1,n): 
  pos = b_r(end,start[i]-1)
  if pos > 0: val = dp[pos -1]+value[i]
  #find project[pos-1] which we can start project[i] after that
  #use b_r so that we can have max number of done projects
  else:
     val = value[i] #if we can't,we will only do project[i]
  dp[i] = max(val,dp[i-1])
print(dp[-1])