import io,os
input = io.BytesIO(os.read(0,os.fstat(0).st_size)).readline
def binary_search(start, end, find):
    if (times[start][0]==find):
        return start
    elif (times[end][0]<find):
        return end+1
    else:
        i=start
        j=end
        while True:
            if (j-i<=1):
                return j           #if you want to return smaller-closest or bigger-closest, make changes here 
            else:
                new_=(j+i)//2
                if (times[new_][0]>find):
                    j=new_
                else:
                    i=new_

def sorter(x):
    return x[0]
n=int(input())
times =[]
for _ in range(n):
    times.append(list(map(int, input().split())))
times.sort(key = sorter)
dp=[0 for _ in range(n+1)]
dp[n]=0
dp[n-1]=times[n-1][2]
for i in range(2,n+1):
    temp=binary_search(0,n-1,times[n-i][1]+0.1)
    dp[-i+n]=max(dp[-i+1+n], times[n-i][2]+dp[temp])
print(dp[0])