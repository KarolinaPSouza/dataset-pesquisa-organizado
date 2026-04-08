
n,x = list(map(int, input().split()))

nums = list(map(int, input().split()))


from collections import Counter
from itertools import combinations



def gen_combs(nums):

    for l in range(len(nums)+1):
        for comb in combinations(nums, l):
            yield sum(comb)

def brute(nums):

    l = [i for i in gen_combs(nums)]


    return Counter(l)

c = brute(nums[:len(nums)//2])

t = 0
for comb in gen_combs(nums[len(nums)//2:]):
    t += c[x-comb]
print(t)