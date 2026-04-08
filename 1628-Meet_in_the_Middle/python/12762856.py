from collections import Counter
import sys

n, x, *values = (int(x) for x in sys.stdin.buffer.read().split())

def subset_sums(values):
    res = [0]
    for v in values:
        res += [s + v for s in res]
    return res

half_n = n // 2
s1 = subset_sums(values[:half_n])
s2 = Counter(subset_sums(values[half_n:]))

print(sum(s2[x - v] for v in s1))