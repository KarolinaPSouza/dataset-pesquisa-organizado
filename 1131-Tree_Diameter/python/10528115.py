from __future__ import annotations

import bisect  # noqa
import heapq  # noqa
import math  # noqa
import statistics  # noqa
import sys
from bisect import bisect_left as lower_bound
from bisect import bisect_right as upper_bound
from collections import Counter, defaultdict, deque  # noqa
from copy import deepcopy  # noqa
from datetime import datetime  # noqa
from fractions import Fraction  # noqa
from functools import lru_cache  # noqa
from itertools import (  # noqa
    permutations, combinations  # difference is that order matters for permutations but not for combinations
)
from typing import Iterator  # noqa

# rewrite input
# sys.stdin = open("cutting.in", "r")
# sys.stdout = open("cutting.out", "w")
user_input = sys.stdin.readline

# allow big recursion
sys.setrecursionlimit(10**5)

# Magic no recursion
from types import GeneratorType  # noqa
def bootstrap(f, stack=[]):  # noqa
    def wrappedfunc(*args, **kwargs):
        if stack:
            return f(*args, **kwargs)
        to = f(*args, **kwargs)
        while True:
            if type(to) is GeneratorType:
                stack.append(to)
                to = next(to)
            else:
                stack.pop()
                if not stack:
                    break
                to = stack[-1].send(to)
        return to

    return wrappedfunc

def get_int() -> int:
    return int(user_input())

def line_integers() -> list[int]:
    return list(map(int, user_input().split()))

def read_matrix(n: int) -> list[list[int]]:
    return [line_integers() for _ in range(n)]

def read_matrix_str(n: int) -> list[list[str]]:
    return [get_string(as_list=True) for _ in range(n)]

def read_matrix_str_blank_separated(n: int) -> list[list[str]]:
    return [get_string(as_list=False).split() for _ in range(n)]

def get_string(as_list: bool = False) -> str | list[str]:
    input_string = user_input()
    if as_list:
        return list(input_string[: len(input_string) - 1])
    else:
        return input_string[: len(input_string) - 1]

def invr() -> Iterator[int]:
    return map(int, user_input().split())

def partitions(partitions_n: int):
    partitions_a = [0 for _ in range(partitions_n + 1)]
    k_ = 1
    y_ = partitions_n - 1
    while k_ != 0:
        x_ = partitions_a[k_ - 1] + 1
        k_ -= 1
        while 2 * x_ <= y_:
            partitions_a[k_] = x_
            y_ -= x_
            k_ += 1
        l_ = k_ + 1
        while x_ <= y_:
            partitions_a[k_] = x_
            partitions_a[l_] = y_
            yield partitions_a[: k_ + 2]
            x_ += 1
            y_ -= 1
        partitions_a[k_] = x_ + y_
        y_ = x_ + y_ - 1
        yield partitions_a[: k_ + 1]

def gen_suffix_array(s_: str) -> list[int]:
    def radix_sort(p_: list[int], c_: list[int]) -> list[int]:
        count: list[int] = [0 for _ in range(len(p_))]
        for x in p_:
            count[c_[x]] += 1
        new_p: list[int] = p_.copy()
        pos: list[int] = [0 for _ in range(len(p_))]
        for i in range(1, len(p_)):
            pos[i] = pos[i-1] + count[i-1]
        for x in p_:
            new_p[pos[c_[x]]] = x
            pos[c_[x]] += 1

        return new_p
    s_ += "$"
    n: int = len(s_)
    a: list[tuple[str, int]] = [(s_[i], i) for i in range(n)]
    a.sort(key=lambda x: x[0])
    p: list[int] = [a[i][1] for i in range(n)]
    c: list[int] = [0] * n
    c[p[0]] = 0
    for i in range(1, n):
        if a[i][0] == a[i-1][0]:
            c[p[i]] = c[p[i-1]]
        else:
            c[p[i]] = c[p[i-1]] + 1
    k: int = 1
    while (1 << k) <= 2*n:
        p = [(p[i] - (1 << (k-1))) % n for i in range(n)]
        p = radix_sort(p, c)

        c_new: list[int] = [0] * n
        prev: tuple[int, int] = (c[p[0]], c[(p[0] + (1 << (k-1))) % n])
        for i in range(1, n):
            curr: tuple[int, int] = (c[p[i]], c[(p[i] + (1 << (k-1))) % n])
            if prev == curr:
                c_new[p[i]] = c_new[p[i-1]]
            else:
                c_new[p[i]] = c_new[p[i-1]] + 1
            prev = curr
        c = c_new
        k += 1
        if c_new[p[n-1]] == n - 1:
            break
    return p

def gen_suffix_array_and_lcp(s_: str) -> tuple[list[int], list[int]]:
    def radix_sort(p_: list[int], c_: list[int]) -> list[int]:
        count: list[int] = [0 for _ in range(len(p_))]
        for x in p_:
            count[c_[x]] += 1
        new_p: list[int] = p_.copy()
        pos: list[int] = [0 for _ in range(len(p_))]
        for i in range(1, len(p_)):
            pos[i] = pos[i-1] + count[i-1]
        for x in p_:
            new_p[pos[c_[x]]] = x
            pos[c_[x]] += 1

        return new_p
    s_ += "$"
    n: int = len(s_)
    a: list[tuple[str, int]] = [(s_[i], i) for i in range(n)]
    a.sort(key=lambda x: x[0])
    p: list[int] = [a[i][1] for i in range(n)]
    c: list[int] = [0] * n
    c[p[0]] = 0
    for i in range(1, n):
        if a[i][0] == a[i-1][0]:
            c[p[i]] = c[p[i-1]]
        else:
            c[p[i]] = c[p[i-1]] + 1
    k: int = 1
    while (1 << k) <= 2*n:
        p = [(p[i] - (1 << (k-1))) % n for i in range(n)]
        p = radix_sort(p, c)

        c_new: list[int] = [0] * n
        prev: tuple[int, int] = (c[p[0]], c[(p[0] + (1 << (k-1))) % n])
        for i in range(1, n):
            curr: tuple[int, int] = (c[p[i]], c[(p[i] + (1 << (k-1))) % n])
            if prev == curr:
                c_new[p[i]] = c_new[p[i-1]]
            else:
                c_new[p[i]] = c_new[p[i-1]] + 1
            prev = curr
        c = c_new
        k += 1
        if c_new[p[n-1]] == n - 1:
            break

    lcp: list[int] = [0] * (n-1)
    k: int = 0
    for i in range(n-1):
        # i => where do we start (in the string) this suffix. we never start the suffix at n-1.
        # because the suffix at n-1 is $ and it is the first of the suffix array so we don't have a previous suffix to 
        # compare it to.
        pi: int = c[i]  # pi => position of the suffix i in the suffix array.
        # pi is never 0 because the suffix at 0 is $
        j: int = p[pi - 1]  # j => where does the previous (in the suffix array) suffix start (in the string).
        while s_[i+k] == s_[j+k]:
            k += 1
        lcp[pi-1] = k
        k = max(k-1, 0)

    return p, lcp

def get_lps(string: str) -> list[int]:
    lps: list[int] = [0] * len(string)
    length: int = 0
    i: int = 1
    while i < len(string):
        if string[i] == string[length]:
            length += 1
            lps[i] = length
            i += 1
        else:
            if length != 0:
                length = lps[length - 1]
            else:
                lps[i] = 0
                i += 1
    return lps

def create_string_hash(string: str, n: int, p: int, mod: int) -> tuple[list[int], list[int]]:
    hash_prefixes: list[int] = [0] * (n + 1)
    powers: list[int] = [1] * (n + 1)
    for i in range(1, n + 1):
        powers[i] = (powers[i - 1] * p) % mod
    for i in range(n):
        hash_prefixes[i + 1] = (hash_prefixes[i] * p + (ord(string[i]) - ord("a") + 1)) % mod
    return hash_prefixes, powers

def get_hash(hash_prefixes: list[int], powers: list[int], mod: int, i: int, j: int) -> int:
    """
    Returns the hash of the substring s[i:j] (j excluded) 
    """
    return (hash_prefixes[j] - hash_prefixes[i] * powers[j-i]) % mod

def make_nCr_mod(max_n: int, mod: int = 10**9+7):
    max_n = min(max_n, mod - 1)

    fact, inv_fact = [0] * (max_n + 1), [0] * (max_n + 1)
    fact[0] = 1
    for i in range(max_n):
        fact[i + 1] = fact[i] * (i + 1) % mod

    inv_fact[-1] = pow(fact[-1], mod - 2, mod)
    for i in reversed(range(max_n)):
        inv_fact[i] = inv_fact[i + 1] * (i + 1) % mod

    def nCr_mod(n, r):
        res = 1
        while n or r:
            a, b = n % mod, r % mod
            if a < b:
                return 0
            res = res * fact[a] % mod * inv_fact[b] % mod * inv_fact[a - b] % mod
            n //= mod
            r //= mod
        return res

    return nCr_mod

def sum_from_k_to_n(k_: int, n_: int) -> int:
    # k inclusive, n inclusive
    return (n_ * (n_ + 1) - k_ * (k_ - 1)) // 2

class FenwickTree:
    def __init__(self, x):
        bit = self.bit = list(x)
        size = self.size = len(bit)
        for i in range(size):
            j = i | (i + 1)
            if j < size:
                bit[j] += bit[i]

    def update(self, idx, x):
        """updates bit[idx] += x"""
        while idx < self.size:
            self.bit[idx] += x
            idx |= idx + 1

    def __call__(self, end):
        """calc sum(bit[:end])"""
        x = 0
        while end:
            x += self.bit[end - 1]
            end &= end - 1
        return x

    def find_kth(self, k):
        """Find largest idx such that sum(bit[:idx]) <= k"""
        idx = -1
        for d in reversed(range(self.size.bit_length())):
            right_idx = idx + (1 << d)
            if right_idx < self.size and self.bit[right_idx] <= k:
                idx = right_idx
                k -= self.bit[idx]
        return idx + 1, k

class SortedList:
    block_size = 700

    def __init__(self, iterable=()):
        self.macro = []
        self.micros = [[]]
        self.micro_size = [0]
        self.fenwick = FenwickTree([0])
        self.size = 0
        for item in iterable:
            self.insert(item)

    def insert(self, x):
        i = lower_bound(self.macro, x)
        j = upper_bound(self.micros[i], x)
        self.micros[i].insert(j, x)
        self.size += 1
        self.micro_size[i] += 1
        self.fenwick.update(i, 1)
        if len(self.micros[i]) >= self.block_size:
            self.micros[i:i + 1] = self.micros[i][:self.block_size >> 1], self.micros[i][self.block_size >> 1:]
            self.micro_size[i:i + 1] = self.block_size >> 1, self.block_size >> 1
            self.fenwick = FenwickTree(self.micro_size)
            self.macro.insert(i, self.micros[i + 1][0])

    def pop(self, k=-1):
        i, j = self._find_kth(k)
        self.size -= 1
        self.micro_size[i] -= 1
        self.fenwick.update(i, -1)
        return self.micros[i].pop(j)

    def __getitem__(self, k):
        i, j = self._find_kth(k)
        return self.micros[i][j]

    def count(self, x):
        return self.upper_bound(x) - self.lower_bound(x)

    def __contains__(self, x):
        return self.count(x) > 0

    def lower_bound(self, x):
        i = lower_bound(self.macro, x)
        return self.fenwick(i) + lower_bound(self.micros[i], x)

    def upper_bound(self, x):
        i = upper_bound(self.macro, x)
        return self.fenwick(i) + upper_bound(self.micros[i], x)

    def _find_kth(self, k):
        return self.fenwick.find_kth(k + self.size if k < 0 else k)

    def __len__(self):
        return self.size

    def __iter__(self):
        return (x for micro in self.micros for x in micro)

    def __repr__(self):
        return str(list(self))

class RangeQuery:
    def __init__(self, data, func):
        self.func = func
        self._data = _data = [data]
        i = 1
        n = len(_data[0])
        while 2 * i <= n:
            prev = _data[-1]
            _data.append(
                [
                    func(prev[j], prev[j + i])
                    for j in range(n - 2 * i + 1)
                ]
            )
            i <<= 1

    def query(self, start, stop):
        """func of data[start, stop)"""
        if start >= stop:
            return 0 
        depth = (stop - start).bit_length() - 1
        return self.func(self._data[depth][start], self._data[depth][stop - (1 << depth)])

    def __getitem__(self, idx):
        return self._data[0][idx]

class SegmentTreeMinMax:
    def __init__(self, nums: list[int]):
        # Let's build the tree
        self.nums: list[int] = nums
        """
        self.nums is the initial array
        """

        self.power: int = 1
        """
        self.power is the smallest power of 2 >= len(nums)
        it will be the length of the last "floor" in the tree
        """
        while self.power < len(nums):
            self.power *= 2

        self.segment_tree: list[tuple[int, int]] = [(10 ** 9 + 1, -10 ** 9 - 1) for _ in range(2 * self.power - 1)]
        """
        self.segment_tree is the actual segment tree (length 2*self.power-1).
        here, we store the minimum value and the maximum value
        """

        # fill the leaves (the leaves are from self.power - 1 to 2*self.power - 1 exclusive for a grand total
        # of self.power elements obviously)
        for idx_ in range(len(nums)):
            self.segment_tree[idx_ + self.power - 1] = (nums[idx_], nums[idx_])

        # fill the internal nodes
        for idx_ in range(self.power - 2, -1, -1):
            self.segment_tree[idx_] = (
                min(self.segment_tree[2 * idx_ + 1][0], self.segment_tree[2 * idx_ + 2][0]),
                max(self.segment_tree[2 * idx_ + 1][1], self.segment_tree[2 * idx_ + 2][1])
            )

    def get_min_max(self, left: int, right: int) -> tuple[int, int]:
        """
        :param left: left index of the query (included)
        :param right: right index of the query (included)
        :return: minimum and maximum of the range [left, right]
        """
        left += self.power - 1
        right += self.power - 1

        mini: int = 10 ** 9 + 1
        maxi: int = -10 ** 9 - 1
        while left <= right:
            # if left is a right child
            if not left % 2:
                mini = min(mini, self.segment_tree[left][0])
                maxi = max(maxi, self.segment_tree[left][1])
                left += 1

            # if right is a left child
            if right % 2:
                mini = min(mini, self.segment_tree[right][0])
                maxi = max(maxi, self.segment_tree[right][1])
                right -= 1

            left //= 2
            right //= 2
            right -= 1

        return mini, maxi

def solve() -> None:
    n: int = get_int()
    graph: list[list[int]] = [[] for _ in range(n)]
    for _ in range(n-1):
        a, b = invr()
        graph[a-1].append(b-1)
        graph[b-1].append(a-1)

    # First DFS
    root = 0
    farthest_first_dfs: int = -1
    farthest_first_dfs_dist: int = -1
    visited: list[bool] = [False] * n
    stack: list[tuple[int, int]] = [(0, root)]
    while stack:
        curr_d, node = stack.pop()
        visited[node] = True
        if curr_d > farthest_first_dfs_dist:
            farthest_first_dfs = node
            farthest_first_dfs_dist = curr_d
        for neigh in graph[node]:
            if not visited[neigh]:
                stack.append((curr_d + 1, neigh))

    # Second DFS
    farthest_second_dfs: int = -1
    farthest_second_dfs_dist: int = -1
    visited = [False] * n
    stack = [(0, farthest_first_dfs)]
    while stack:
        curr_d, node = stack.pop()
        visited[node] = True
        if curr_d > farthest_second_dfs_dist:
            farthest_second_dfs = node
            farthest_second_dfs_dist = curr_d
        for neigh in graph[node]:
            if not visited[neigh]:
                stack.append((curr_d + 1, neigh))

    print(farthest_second_dfs_dist)


if __name__ == "__main__":
    # n_tests: int = get_int()
    # test_nb: int
    # for test_nb in range(n_tests):
    #     solve()

    solve()