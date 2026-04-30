# Subarray Sum Queries
# https://cses.fi/problemset/task/1190
 
# There is an array consisting of n integers. Some values of the array will be updated, and after each update, your task is to report the maximum subarray sum in the array. 
 
import sys
 
# Input
# The first input line contains integers n and m: the size of the array and the number of updates. The array is indexed 1,2,\ldots,n.
# The next line has n integers: x_1,x_2,\ldots,x_n: the initial contents of the array.
# Then there are m lines describing the changes. Each line has two integers k and x: the value at position k becomes x.
 
n, m, *rest = [int(x) for x in sys.stdin.buffer.read().split()]
values = rest[:n]
changes = rest[n:]
 
# Data structure: a tree that stores:
# - sum
# - maximum subarray sum
# - maxium subarray sum starting at the beginning
# - maxium subarray sum ending at the end
 
level0 = []
for v in values:
    if v > 0:
        level0.extend([v, v, v, v])
    else:
        level0.extend([v, 0, 0, 0])
 
# Extend values to a power of 2, padding with zeros on the right
n = 1 << (n - 1).bit_length()
level0.extend([0] * (4 * n - len(level0)))
 
def combine(lower, higher, index):
    """Combine two nodes into a new node at the higher level."""
 
    s_l = lower[index]
    m_l = lower[index + 1]
    m_b_l = lower[index + 2]
    m_e_l = lower[index + 3]
    s_r = lower[index + 4]
    m_r = lower[index + 5]
    m_b_r = lower[index + 6]
    m_e_r = lower[index + 7]
    
    index >>= 1
    higher[index] = s_l + s_r
    higher[index + 1] = max(m_l, m_r, m_e_l + m_b_r)
    higher[index + 2] = max(m_b_l, s_l + m_b_r)
    higher[index + 3] = max(m_e_r, s_r + m_e_l)
    return index
 
# Build the tree
tree = [last_level := level0]
while len(last_level) > 4:
    tree.append(new_level := [0] * (len(last_level) >> 1))
    for idx in range(0, len(last_level), 8):
        combine(last_level, new_level, idx)
    last_level = new_level
root = last_level
 
# Update the tree after each update
res = []
for idx, v in zip(changes[::2], changes[1::2]):
    idx = (idx - 1) * 4
    level0[idx] = v
    level0[idx + 1] = level0[idx + 2] = level0[idx + 3] = max(v, 0)
    lower = level0
    for higher in tree[1:]:
        idx &= -8  # clear last 3 bits
        idx = combine(lower, higher, idx)
        lower = higher
    res.append(root[1])
 
# Output
# After each update, print the maximum subarray sum. Empty subarrays (with sum 0) are allowed.
print('\n'.join(map(str, res)))