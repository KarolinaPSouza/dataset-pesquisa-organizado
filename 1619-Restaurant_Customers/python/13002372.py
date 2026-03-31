n =int(input())
arr = []
dep = []
for i in range(n):
        a ,d = map(int , input().split())
        arr.append(a)
        dep.append(d)
arr.sort()
dep.sort()
def check(arr , dep , k):
        cnt =0
        i=0
        j=0
        while(i < n):
                if arr[i] <= dep[j]:
                        cnt+=1
                        i+=1
                        if cnt >= k:
                                return True
                else:
                        cnt-=1
                        j+=1
        return False

l =0 
r = max(max(dep) , max(arr))
ans = 1
while(l<=r):
        mid = (l+r)//2
        if check(arr , dep , mid):
                ans = mid
                l = mid+1
        else:
                r = mid-1
print(ans)

