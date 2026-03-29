import bisect


def binarySearch(n,ed):

    x=bisect.bisect_left(ed,n)


    if x==0:
        return 0

    return x



n=int(input())
l=[]

for i in range(n):
    l.append(tuple(map(int,input().split())))



l.sort(key=lambda a:a[1])

dp=[0]*(n+1) 
endDate=[]

for i in range(n):
    endDate.append(l[i][1])

dp[0]=0
for i in range(1,n+1):

    notPick=dp[i-1]
    pick=l[i-1][2]

    ans=binarySearch(l[i-1][0],endDate)

    pick+=dp[ans]  

    dp[i]=max(notPick,pick)



print(dp[n])