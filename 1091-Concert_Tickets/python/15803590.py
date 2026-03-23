n,m = tuple(map(int,input().split(' ')))
h = list(map(int,input().split(' ')))
t = list(map(int,input().split(' ')))

h.sort()

nearest = [i for i in range(n)]

def find(i):
    if(i==-1 or nearest[i] == i):
        return i

    if nearest[i] == -1:
        return -1

    nearest[i] = find(nearest[i])
    return nearest[i]

def bin(val):
    l = 0
    r = n-1
    ans = -1
    while l<=r:
        mid = l+(r-l)//2
        if h[mid]<=val:
            ans = mid
            l = mid+1
        else:
            r = mid-1

    return ans

def update(idx):
    if(idx==-1):
        return
    nearest[idx] = find(idx-1)

for v in t:
    # print(v,bin(v))
    ans = find(bin(v))
    update(ans)
    # print(nearest)
    print(ans if ans ==-1 else h[ans])