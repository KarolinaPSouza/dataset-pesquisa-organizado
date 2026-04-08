n,x=map(int,input().split())
a=list(map(int,input().split()))
l=a[:n//2]
r=a[n//2:]
def subset_genrator(arr):
    ans=[]
    def f(i,s):
        if i==len(arr):
            ans.append(s)
            return
        s+=arr[i]
        f(i+1,s)
        s-=arr[i]
        f(i+1,s)
    f(0,0)
    return ans
ls=subset_genrator(l)
rs=subset_genrator(r)
ls.sort()
rs.sort()
n1, n2 = len(ls), len(rs)
i, j = 0, n2 - 1
ans = 0

while i < n1 and j >= 0:
    s = ls[i] + rs[j]

    if s > x:
        j -= 1
    elif s < x:
        i += 1
    else:  
        cnt_i = 1
        while i + cnt_i < n1 and ls[i + cnt_i] == ls[i]:
            cnt_i += 1


        cnt_j = 1
        while j - cnt_j >= 0 and rs[j - cnt_j] == rs[j]:
            cnt_j += 1

        ans += cnt_i * cnt_j

        i += cnt_i
        j -= cnt_j

print(ans)


