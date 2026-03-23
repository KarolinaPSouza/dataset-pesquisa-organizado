a,b,n=map(int,input().split())
arr=list(map(int,input().split()))
brr=list(map(int,input().split()))
arr.sort()
brr.sort()
i=0
p=0
j=0
while i<a and j<b:
    if abs(arr[i]-brr[j])<=n:
        i+=1
        j+=1
        p+=1
    else:
        if arr[i]-brr[j]<0:
            i+=1
        else :
            j+=1
print(p)