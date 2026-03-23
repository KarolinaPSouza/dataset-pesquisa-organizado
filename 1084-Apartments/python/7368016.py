n,m,x=map(int,input().split())
arr=list(map(int,input().split()))
nums=list(map(int,input().split()))
arr.sort();nums.sort()
l,r=0,0
cnt=0
while l<m and r<n:
    if nums[l]-x<=arr[r] and  nums[l]+x>=arr[r]:
        cnt+=1
        l+=1
        r+=1
    elif nums[l]-x>arr[r]:
        r+=1
    elif nums[l]+x<arr[r]:
        l+=1

print(cnt)

