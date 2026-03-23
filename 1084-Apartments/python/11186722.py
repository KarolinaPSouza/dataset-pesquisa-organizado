n,m,k=map(int,input().split())
arr= list(map(int,input().split()))
brr  = list(map(int,input().split()))

arr.sort()
brr.sort()
i=0
j=0
cnt=0
while i<len(arr) and j<len(brr):
    if arr[i]-k <= brr[j] <= arr[i]+k:
        i+=1
        j+=1
        cnt+=1
    elif brr[j] < arr[i]-k:
        j+=1
    elif brr[j] > arr[i]+k:
        i+=1
print(cnt)