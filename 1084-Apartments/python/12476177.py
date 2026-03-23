n,m,k = map(int,input().split())
n_arr = list(map(int,input().split()))
m_arr = list(map(int,input().split()))
n_arr.sort()
m_arr.sort()
i=0
j=0
ans=0
while i<n and j<m:
    if abs(n_arr[i] - m_arr[j]) <= k:
        ans+=1
        i+=1
        j+=1
    else:
        if n_arr[i]-m_arr[j] > k:
            j+=1
        else:
            i+=1
print(ans)



