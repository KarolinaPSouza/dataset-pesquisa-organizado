n, x = list(map(int, input().split()))
nums = list(map(int, input().split()))

def findsum(d1, d2):
    tot = 0
    ugu = 1
    d1.sort()
    d2.sort()
    j = len(d2)-1
    for i in range(len(d1)):
        if i != len(d1) - 1:
            if d1[i] == d1[i + 1]:
                ugu += 1
                continue
        while j >= 0 and d1[i] + d2[j] > x:
            j -= 1
        while j>=0 and d1[i] + d2[j] == x:
            j -= 1
            tot += ugu
        ugu = 1
    return tot

def getsums(l):
    ds = [0]
    for k in l:
        ll = len(ds)
        for i in range(ll):
            if ds[i] + k <= x:
                ds.append(ds[i] + k)
    ds.sort()
    return ds

s1 = getsums(nums[0:20])
s2 = getsums(nums[20:])

print(findsum(s1, s2))