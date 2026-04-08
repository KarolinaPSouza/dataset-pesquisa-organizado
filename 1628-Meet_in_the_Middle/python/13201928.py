#4 5
#1 2 3 2



n, x = [i for i in map(int, input().split(" "))]
nums = [i for i in map(int, input().split(" "))]

#n, x = [i for i in map(int, "40 535756851".split(" "))]
#nums = [i for i in map(int, "53357810 106104474 535756852 26895296 22759287 22649960 59518341 89937933 66551417 108165176 60769395 40856786 24837586 97998406 32141992 29319377 59773501 23116486 88212191 94890437 67167160 102249071 133180023 75207798 112534489 100353035 48382599 41233714 31230763 89439231 58916618 94307399 80079112 78741483 113133423 178528162 267782866 67820409 37849639 18244013".split(" "))]



# def count(index, target):
#     if target == 0:
#         return 1
#     if index == n:
#         return 0
#     if nums[index]>target:
#         return 0
#     return count(index + 1, target) + count(index + 1, target-nums[index])

sums = {0:1}
def joindicts(d1, d2):
    d3 = {0:0}
    for i in d1.keys():
        for j in d2.keys():
            if i + j > x:
                continue
            if i+j in d3:
                d3[i+j] += d1[i] * d2[j]
            else:
                d3[i+j] = d1[i] * d2[j]
    return d3

def findsum(d1, d2):
    # l1 = list(d1.keys())
    # l2 = list(d2.keys())
    # l1.sort()
    # l2.sort()
    # count=0
    # for i in l1:
    #     if i > x:
    #         return
    #     for j in l2:
    #         if i + j > x:
    #             break
    #         if i + j == x:
    #             count += d1[i]*d2[j]
    count = 0
    for i in d1:
        if x-i in d2:
            count += d1[i]*d2[x-i]

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

# for i in range(n):
#     revs = list(sums.keys())
#     revs.sort(reverse=True)
#     for j in revs:
#         if j + nums[i] > x: 
#             continue
#         if j + nums[i] in sums:
#             sums[j + nums[i]] += sums[j]
#         else:
#             sums[j + nums[i]] = sums[j]
s1 = getsums(nums[0:10])
s2 = getsums(nums[10:20])
s3 = getsums(nums[20:30])
s4 = getsums(nums[30:])

t1=joindicts(s1, s2)
t2=joindicts(s3, s4)
print(findsum(t1,t2))