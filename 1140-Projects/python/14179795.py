import sys

def main():
    input = sys.stdin.readline
    n=int(input())
    arr=[list(map(int,input().split())) for _ in range(n)]
    arr.sort(key=lambda x: x[1])

    dp=[0]*(n)
    dp[0]=arr[0][2]
    def fun(i):
        l,h=0,n-1
        ans=-1
        while l<=h:
            mid=(l+h)//2
            if arr[mid][1]<arr[i][0]:
                ans=mid
                l=mid+1
            else:
                h=mid-1
        return ans
    for i in range(1,n):
        val=0
        ans=fun(i)
        if ans!=-1:
            val=dp[ans]+arr[i][2]
        else:
            val=arr[i][2]
        dp[i]=max(dp[i-1],val)
    print(dp[-1])





if __name__ == "__main__":
    main()