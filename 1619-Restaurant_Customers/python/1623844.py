# n,m=map(int,input().split())
# l1=list(map(int,input().split()))
n=int(input())
maxi=-10**10
lst=[]
arr=[]
leave=[]
for i in range(n):
    x,y=map(int,input().split())
    a=[x,y]
    arr.append(x)
    leave.append(y)
# lst.sort(key = lambda x: x[0])
arr.sort()
leave.sort()
one=1
ans=0
curr=0
i=one-one
j=one-one
while i<n and j<n:
    if arr[i]<leave[j]:
        curr+=one
        i+=one
    else:
        curr-=one
        j+=one
    if ans<curr:
        ans=curr
print(ans)