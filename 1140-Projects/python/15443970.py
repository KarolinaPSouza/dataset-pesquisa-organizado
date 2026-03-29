I = lambda: map(int, input().split())

n, = I()
projects = []
for i in range(n):
    a,b,c = I()
    projects.append([a,b,c])

projects.sort(key = lambda x:x[1])
starts = [proj[0] for proj in projects]
ends = [proj[1] for proj in projects]
prof = [proj[2] for proj in projects]

def low_bnd(ar, x):
    low, high = 0, len(ar)-1
    ans = -1
    while low<=high:
        mid = (low+high)//2
        if ar[mid]<x:
            ans = mid
            low = mid+1
        else:
            high = mid-1
    return ans
dp = [0]*(n+1)

for i in range(1,n+1):
    sta = starts[i-1]
    end = ends[i-1]
    we = prof[i-1]
    j = low_bnd(ends,sta)

    take = we + (dp[j+1] if j!=-1 else 0)
    skip = dp[i-1]
    dp[i] = max(take,skip)

print(dp[n])

