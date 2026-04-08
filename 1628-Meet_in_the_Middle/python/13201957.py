n, x = [i for i in map(int, input().split(" "))]
nums = [i for i in map(int, input().split(" "))]

sums = {0:1}
def joindicts(d1, d2):
    d3 = {0:0}
    for i in d1.keys():
        for j in d2.keys():
            if i + j > x:
                continue
            if i + j in d3:
                d3[i+j] += d1[i] * d2[j]
            else:
                d3[i+j] = d1[i] * d2[j]
    return d3

def findsum(d1, d2):
    count = 0
    for i in d1:
        if x-i in d2:
            count += d1[i] * d2[x-i]

    return count

def getsums(l):
    ds = {0:1}
    for k in l:
        revs = list(ds.keys())
        revs.sort(reverse=True)
        for j in revs:
            if j + k > x: 
                continue
            if j + k in ds:
                ds[j + k] += ds[j]
            else:
                ds[j + k] = ds[j]
    return ds

s1 = getsums(nums[0:10])
s2 = getsums(nums[10:20])
s3 = getsums(nums[20:30])
s4 = getsums(nums[30:])

t1 = joindicts(s1, s2)
t2 = joindicts(s3, s4)

print(findsum(t1, t2))