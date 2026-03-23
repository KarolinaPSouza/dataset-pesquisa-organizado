import math
n = int(input())
M = 1000000007
ans = 0
rtn = int(math.sqrt(n))
for i in range(1,rtn+1):
    ans = (ans%M) + ((n//i-i+1)*i)%M
    ans = ans%M
    var = ((n//i)*(n//i+1))//2
    var = var%M

    var2 = (i * (i+1)) // 2
    var2 = var2%M

    ans = (ans%M) + (var-var2)%M
    ans = ans%M

print(ans)