# import sys
 
# class Node:
#     def __init__(self, mx, pre, suf, sm):
#         self.mx = mx
#         self.pre = pre
#         self.suf = suf
#         self.sm = sm
#     def __repr__(self):
#         return f"Node({self.mx}, {self.pre}, {self.suf}, {self.sm})"
 
# def segfunc(n1, n2):
#     mx = max(n1.mx, n2.mx, n1.suf + n2.pre)
#     pre = max(n1.pre, n1.sm + n2.pre)
#     suf = max(n2.suf, n1.suf + n2.sm)
#     sm = n1.sm + n2.sm
#     return Node(mx, pre, suf, sm)
 
 
# class SegmentTree:
#     def __init__(self, data, default=Node(0,0,0,0), func=segfunc):
#         """initialize the segment tree with data"""
#         self._default = default
#         self._func = func
#         self._len = len(data)
#         self._size = _size = 1 << (self._len - 1).bit_length()
 
#         self.data = [default] * (2 * _size)
#         self.data[_size:_size + self._len] = data
#         for i in reversed(range(_size)):
#             self.data[i] = func(self.data[i + i], self.data[i + i + 1])
 
#     def __delitem__(self, idx):
#         self[idx] = self._default
 
#     def __getitem__(self, idx):
#         return self.data[idx + self._size]
 
#     def __setitem__(self, idx, value):
#         idx += self._size
#         self.data[idx] = value
#         idx >>= 1
#         while idx:
#             self.data[idx] = self._func(self.data[2 * idx], self.data[2 * idx + 1])
#             idx >>= 1
 
#     def __len__(self):
#         return self._len
 
#     def query(self, start, stop):
#         """func of data[start, stop)"""
#         start += self._size
#         stop += self._size
 
#         res_left = res_right = self._default
#         while start < stop:
#             if start & 1:
#                 res_left = self._func(res_left, self.data[start])
#                 start += 1
#             if stop & 1:
#                 stop -= 1
#                 res_right = self._func(self.data[stop], res_right)
#             start >>= 1
#             stop >>= 1
 
#         return self._func(res_left, res_right)
 
#     def __repr__(self):
#         return "SegmentTree({0})".format(self.data)
 
# inp = sys.stdin.read().splitlines()
# n, q = map(int, inp[0].split())
# arr = [*map(int, inp[1].split())]
# st=SegmentTree([Node(i,i,i,i) for i in arr])
# ans=[]
# for line in inp[2:]:
#     k,x=map(int, line.split())
#     st[k-1]=Node(x,x,x,x)
#     ans.append(str(st.query(0,n).mx))
# print("\n".join(ans))
 
import sys
 
n, q = [int(s) for s in sys.stdin.readline().split()]
n = 1<<(n.bit_length())
arr = [int(s) for s in sys.stdin.readline().split()]
 
sum_ = [0] * 2 * n
prefix_ = [0] * 2 * n
suffix_ = [0] * 2 * n
subsum_ = [0] * 2 * n
 
 
def build():
    for i, a in enumerate(arr):
        sum_[n + i] = a
        prefix_[n + i] = a if a > 0 else 0
        suffix_[n + i] = a if a > 0 else 0
        subsum_[n + i] = a
    a = n >> 1
    b = n
    while a:
        for i in range(a, b):
            sum_[i] = sum_[i << 1] + sum_[i << 1 | 1]
            prefix_[i] = max(prefix_[i << 1], sum_[i << 1] + prefix_[i << 1 | 1])
            suffix_[i] = max(suffix_[i << 1 | 1], suffix_[i << 1] + sum_[i << 1 | 1])
            subsum_[i] = max(subsum_[i << 1], subsum_[i << 1 | 1], suffix_[i << 1] + prefix_[i << 1 | 1])
        a >>= 1
        b >>= 1
 
 
def update(k, x):
    k += n
    sum_[k] = x
    prefix_[k] = x if x > 0 else 0
    suffix_[k] = x if x > 0 else 0
    subsum_[k] = x
    while k > 1:
        k >>= 1
        sum_[k] = sum_[k << 1] + sum_[k << 1 | 1]
        prefix_[k] = max(prefix_[k << 1], sum_[k << 1] + prefix_[k << 1 | 1])
        suffix_[k] = max(suffix_[k << 1 | 1], suffix_[k << 1] + sum_[k << 1 | 1])
        subsum_[k] = max(subsum_[k << 1], subsum_[k << 1 | 1], suffix_[k << 1] + prefix_[k << 1 | 1])
 
 
build()
 
ans = []
for _ in range(q):
    k, x = [int(s) for s in sys.stdin.readline().split()]
    update(k - 1, x)
    ans.append(subsum_[1])
 
print('\n'.join((str(s) for s in ans)))