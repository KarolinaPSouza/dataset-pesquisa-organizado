import os
import sys
from io import BytesIO, IOBase
from collections import *
import math
from bisect import bisect_left,bisect_right
#bruh
#easy bin searcg




def solve():
    numNodes = int(input())
    tree = defaultdict(list)
    maxDepth = defaultdict(int)
    for _ in range(numNodes-1):
        parent, child = map(int, input().split())
        tree[parent].append(child)
        tree[child].append(parent)
    tree[1].append(-1)
    inDP = defaultdict(int)
    stack = [(1, -1, False)]
    while stack:
        currNode, parent, up = stack.pop()
        if up:
            if len(tree[currNode]) == 1:
                inDP[currNode] = 0
            else:
                inDP[currNode] = 1 + max([inDP[child] for child in tree[currNode] if child != parent])
        else:
            stack.append((currNode, parent, True))
            for child in tree[currNode]:
                if child == parent: continue
                stack.append((child, currNode, False))

    outDP = defaultdict(int)
    outDP[1] = 0
    stack = [(1,-1)]
    while stack:
        currNode, parent = stack.pop()
        for child in tree[currNode]:
            if child == parent:
                continue
            stack.append((child, currNode))
        numChildren = 0
        children = []
        for child in tree[currNode]:
            if child == parent:
                continue
            children.append(child)
        if len(children) == 1:
            onlyChild = children[0]
            outDP[onlyChild] = 1 + outDP[currNode]
        else:
            mx1 = -1
            mx2 = -1
            for child in children:
                if inDP[child] >= mx1:
                    mx2 = mx1
                    mx1 = inDP[child]
                elif inDP[child] >= mx2:
                    mx2 = inDP[child]
            for child in children:
                if inDP[child] == mx1:
                    outDP[child] = max(2 + mx2, 1 + outDP[currNode])
                else:
                    outDP[child] = max(2 + mx1, 1 + outDP[currNode])


    for i in range(1, numNodes+1):
        print(max(inDP[i], outDP[i]), end = " ")





















#first true in sorted array or good():
    # boundary_index = -1
    #left, right = 0, len(arr) - 1
    # while left <= right:
    #     mid = (left + right) // 2
    #     if good(mid):
    #         boundary_index = mid
    #         right = mid - 1
    #     else:
    #         left = mid + 1

    # return boundary_index






























def main():
    #for _ in range(int(input())):
    solve()


    # [3 7]
    # 2 4 6




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


def connected_components(n, graph):
    components, visited = [], [False] * (n+2)

    def dfs(start):
        component, stack = [], [start]

        while stack:
            start = stack[-1]

            if visited[start]:
                stack.pop()
                continue
            else:
                visited[start] = True
                component.append(start)

            for i in graph[start]:
                if not visited[i]:
                    stack.append(i)

        return component

    for i in range(1,n+1):
        if not visited[i]:
            components.append(dfs(i))

    return components

from collections import Counter


def gcd(x, y):
    """greatest common divisor of x and y"""
    while y:
        x, y = y, x % y
    return x


def memodict(f):
    """memoization decorator for a function taking a single argument"""
    class memodict(dict):
        def __missing__(self, key):
            ret = self[key] = f(key)
            return ret

    return memodict().__getitem__


def pollard_rho(n):
    """returns a random factor of n"""
    if n & 1 == 0:
        return 2
    if n % 3 == 0:
        return 3

    s = ((n - 1) & (1 - n)).bit_length() - 1
    d = n >> s
    for a in [2, 325, 9375, 28178, 450775, 9780504, 1795265022]:
        p = pow(a, d, n)
        if p == 1 or p == n - 1 or a % n == 0:
            continue
        for _ in range(s):
            prev = p
            p = (p * p) % n
            if p == 1:
                return gcd(prev - 1, n)
            if p == n - 1:
                break
        else:
            for i in range(2, n):
                x, y = i, (i * i + 1) % n
                f = gcd(abs(x - y), n)
                while f == 1:
                    x, y = (x * x + 1) % n, (y * y + 1) % n
                    y = (y * y + 1) % n
                    f = gcd(abs(x - y), n)
                if f != n:
                    return f
    return n


@memodict
def prime_factors(n):
    """returns a Counter of the prime factorization of n"""
    if n <= 1:
        return Counter()
    f = pollard_rho(n)
    return Counter([n]) if f == n else prime_factors(f) + prime_factors(n // f)


def distinct_factors(n):
    """returns a list of all distinct factors of n"""
    factors = [1]
    for p, exp in prime_factors(n).items():
        factors += [p**i * factor for factor in factors for i in range(1, exp + 1)]
    return factors


def all_factors(n):
    """returns a sorted list of all distinct factors of n"""
    small, large = [], []
    for i in range(1, int(n**0.5) + 1, 2 if n & 1 else 1):
        if not n % i:
            small.append(i)
            large.append(n // i)
    if small[-1] == large[-1]:
        large.pop()
    large.reverse()
    small.extend(large)
    return small


#sorted list stuff
def next_smaller(arr, value, start = 0, end = None):
    """Return strictly smaller value to the given value."""

    if end is None:
        i = bisect_left(arr, value) - 1
        if i < 0:
            return None
        return arr[i]
    else:
        i = bisect_left(arr, value, start, end) - 1
        if i < 0:
            return None
        return arr[i]


def next_smalleri(arr, value, start = 0, end = None):
    """Return strictly smaller value to the given value."""

    if end is None:
        i = bisect_left(arr, value) - 1
        if i < 0:
            return None
        return i
    else:
        i = bisect_left(arr, value,start=0,end=None) - 1
        if i < 0:
            return None
        return i

def floor(arr, value, start = 0, end = None):
    """Return smaller or equal value than the given value."""
    if end is None:
        i = bisect_right(arr, value) - 1
        if i < 0:
            return None
        return arr[i]
    else:
        i = bisect_right(arr, value,start, end) - 1
        if i < 0:
            return None
        return arr[i]


def floori(arr, value, start = 0, end = None):
    """Return smaller or equal value than the given value."""
    if end is None:
        i = bisect_right(arr, value) - 1
        if i < 0:
            return None
        return i
    else:
        i = bisect_right(arr, value,start,end) - 1
        if i < 0:
            return None
        return i


def ceil(arr, value, start = 0, end = None):
    """Return larger or equal value than the given value."""
    if end is None:
        i = bisect_left(arr, value)
        if i >= len(arr):
            return None
        return arr[i]
    else:
        i = bisect_left(arr, value,start,end)
        if i >= len(arr):
            return None
        return arr[i]      

def ceili(arr, value,start=0,end=None):
    """Return larger or equal value than the given value."""
    if end is None:
        i = bisect_left(arr, value)
        if i >= len(arr):
            return None
        return i
    else:
        i = bisect_left(arr, value,start,end)
        if i >= len(arr):
            return None
        return i

def next_greater(arr, value,start=0,end=None):
    """Return strictly larger value than the given value."""
    if end is None:
        i = bisect_right(arr, value)
        if i >= len(arr):
            return None
        return arr[i]
    else:
        i = bisect_right(arr, value,start,end)
        if i >= len(arr):
            return None
        return arr[i]

def next_greateri(arr, value,start=0,end=None):
    """Return strictly larger value than the given value."""
    if end is None:
        i = bisect_right(arr, value)
        if i >= len(arr):
            return None
        return i
    else:
        i = bisect_right(arr, value,start,end)
        if i >= len(arr):
            return None
        return i

def index_of(in_list, val):
    try:
        return in_list.index(val)
    except ValueError:
        return -1 

import random


class TreapMultiSet(object):
    root = 0
    size = 0

    def __init__(self, data=None):
        if data:
            data = sorted(data)
            self.root = treap_builder(data)
            self.size = len(data)

    def add(self, key):
        self.root = treap_insert(self.root, key)
        self.size += 1

    def remove(self, key):
        self.root = treap_erase(self.root, key)
        self.size -= 1

    def discard(self, key):
        try:
            self.remove(key)
        except KeyError:
            pass

    def ceiling(self, key):
        x = treap_ceiling(self.root, key)
        return treap_keys[x] if x else None

    def higher(self, key):
        x = treap_higher(self.root, key)
        return treap_keys[x] if x else None

    def floor(self, key):
        x = treap_floor(self.root, key)
        return treap_keys[x] if x else None

    def lower(self, key):
        x = treap_lower(self.root, key)
        return treap_keys[x] if x else None

    def max(self):
        return treap_keys[treap_max(self.root)]

    def min(self):
        return treap_keys[treap_min(self.root)]

    def __len__(self):
        return self.size

    def __nonzero__(self):
        return bool(self.root)

    __bool__ = __nonzero__

    def __contains__(self, key):
        return self.floor(key) == key

    def __repr__(self):
        return "TreapMultiSet({})".format(list(self))

    def __iter__(self):
        if not self.root:
            return iter([])
        out = []
        stack = [self.root]
        while stack:
            node = stack.pop()
            if node > 0:
                if right_child[node]:
                    stack.append(right_child[node])
                stack.append(~node)
                if left_child[node]:
                    stack.append(left_child[node])
            else:
                out.append(treap_keys[~node])
        return iter(out)


class TreapSet(TreapMultiSet):
    def add(self, key):
        self.root, duplicate = treap_insert_unique(self.root, key)
        if not duplicate:
            self.size += 1

    def __repr__(self):
        return "TreapSet({})".format(list(self))


class TreapHashSet(TreapMultiSet):
    def __init__(self, data=None):
        if data:
            self.keys = set(data)
            super(TreapHashSet, self).__init__(self.keys)
        else:
            self.keys = set()

    def add(self, key):
        if key not in self.keys:
            self.keys.add(key)
            super(TreapHashSet, self).add(key)

    def remove(self, key):
        self.keys.remove(key)
        super(TreapHashSet, self).remove(key)

    def discard(self, key):
        if key in self.keys:
            self.remove(key)

    def __contains__(self, key):
        return key in self.keys

    def __repr__(self):
        return "TreapHashSet({})".format(list(self))


class TreapHashMap(TreapMultiSet):
    def __init__(self, data=None):
        if data:
            self.map = dict(data)
            super(TreapHashMap, self).__init__(self.map.keys())
        else:
            self.map = {}

    def __setitem__(self, key, value):
        if key not in self.map:
            super(TreapHashMap, self).add(key)
        self.map[key] = value

    def __getitem__(self, key):
        return self.map[key]

    def add(self, key):
        raise TypeError("add on TreapHashMap")

    def get(self, key, default=None):
        return self.map.get(key, default)

    def remove(self, key):
        self.map.pop(key)
        super(TreapHashMap, self).remove(key)

    def discard(self, key):
        if key in self.map:
            self.remove(key)

    def __contains__(self, key):
        return key in self.map

    def __repr__(self):
        return "TreapHashMap({})".format(list(self))


left_child = [0]
right_child = [0]
treap_keys = [0]
treap_prior = [0.0]


def treap_builder(sorted_data):
    """Build a treap in O(n) time using sorted data"""
    def build(begin, end):
        if begin == end:
            return 0
        mid = (begin + end) // 2
        root = treap_create_node(sorted_data[mid])
        left_child[root] = build(begin, mid)
        right_child[root] = build(mid + 1, end)

        # sift down the priorities
        ind = root
        while True:
            lc = left_child[ind]
            rc = right_child[ind]

            if lc and treap_prior[lc] > treap_prior[ind]:
                if rc and treap_prior[rc] > treap_prior[lc]:
                    treap_prior[ind], treap_prior[rc] = treap_prior[rc], treap_prior[ind]
                    ind = rc
                else:
                    treap_prior[ind], treap_prior[lc] = treap_prior[lc], treap_prior[ind]
                    ind = lc
            elif rc and treap_prior[rc] > treap_prior[ind]:
                treap_prior[ind], treap_prior[rc] = treap_prior[rc], treap_prior[ind]
                ind = rc
            else:
                break
        return root

    return build(0, len(sorted_data))


def treap_create_node(key):
    treap_keys.append(key)
    treap_prior.append(random.random())
    left_child.append(0)
    right_child.append(0)
    return len(treap_keys) - 1


def treap_split(root, key):
    left_pos = right_pos = 0
    while root:
        if key < treap_keys[root]:
            left_child[right_pos] = right_pos = root
            root = left_child[root]
        else:
            right_child[left_pos] = left_pos = root
            root = right_child[root]
    left, right = right_child[0], left_child[0]
    right_child[left_pos] = left_child[right_pos] = right_child[0] = left_child[0] = 0
    return left, right


def treap_merge(left, right):
    where, pos = left_child, 0
    while left and right:
        if treap_prior[left] > treap_prior[right]:
            where[pos] = pos = left
            where = right_child
            left = right_child[left]
        else:
            where[pos] = pos = right
            where = left_child
            right = left_child[right]
    where[pos] = left or right
    node = left_child[0]
    left_child[0] = 0
    return node


def treap_insert(root, key):
    if not root:
        return treap_create_node(key)
    left, right = treap_split(root, key)
    return treap_merge(treap_merge(left, treap_create_node(key)), right)


def treap_insert_unique(root, key):
    if not root:
        return treap_create_node(key), False
    left, right = treap_split(root, key)
    if left and treap_keys[left] == key:
        return treap_merge(left, right), True
    return treap_merge(treap_merge(left, treap_create_node(key)), right), False


def treap_erase(root, key):
    if not root:
        raise KeyError(key)
    if treap_keys[root] == key:
        return treap_merge(left_child[root], right_child[root])
    node = root
    while root and treap_keys[root] != key:
        parent = root
        root = left_child[root] if key < treap_keys[root] else right_child[root]
    if not root:
        raise KeyError(key)
    if root == left_child[parent]:
        left_child[parent] = treap_merge(left_child[root], right_child[root])
    else:
        right_child[parent] = treap_merge(left_child[root], right_child[root])

    return node


def treap_ceiling(root, key):
    while root and treap_keys[root] < key:
        root = right_child[root]
    if not root:
        return 0
    min_node = root
    min_key = treap_keys[root]
    while root:
        if treap_keys[root] < key:
            root = right_child[root]
        else:
            if treap_keys[root] < min_key:
                min_key = treap_keys[root]
                min_node = root
            root = left_child[root]
    return min_node


def treap_higher(root, key):
    while root and treap_keys[root] <= key:
        root = right_child[root]
    if not root:
        return 0
    min_node = root
    min_key = treap_keys[root]
    while root:
        if treap_keys[root] <= key:
            root = right_child[root]
        else:
            if treap_keys[root] < min_key:
                min_key = treap_keys[root]
                min_node = root
            root = left_child[root]
    return min_node


def treap_floor(root, key):
    while root and treap_keys[root] > key:
        root = left_child[root]
    if not root:
        return 0
    max_node = root
    max_key = treap_keys[root]
    while root:
        if treap_keys[root] > key:
            root = left_child[root]
        else:
            if treap_keys[root] > max_key:
                max_key = treap_keys[root]
                max_node = root
            root = right_child[root]
    return max_node


def treap_lower(root, key):
    while root and treap_keys[root] >= key:
        root = left_child[root]
    if not root:
        return 0
    max_node = root
    max_key = treap_keys[root]
    while root:
        if treap_keys[root] >= key:
            root = left_child[root]
        else:
            if treap_keys[root] > max_key:
                max_key = treap_keys[root]
                max_node = root
            root = right_child[root]
    return max_node


def treap_min(root):
    if not root:
        raise ValueError("min on empty treap")
    while left_child[root]:
        root = left_child[root]
    return root


def treap_max(root):
    if not root:
        raise ValueError("max on empty treap")
    while right_child[root]:
        root = right_child[root]
    return root


class Node:
    def __init__(self, value):
        self.value = value
        self.next = None
        self.prev = None

    def __repr__(self):
        return self.__class__.__name__ + ("({})".format(self.value) if self else "()")


class LinkedList:
    def __init__(self, iterable=None):
        self.sentinel = Node(None)
        self.sentinel.next = self.sentinel
        self.sentinel.prev = self.sentinel
        self.__len = 0
        if iterable is not None:
            self += iterable

    def get_node(self, index):
        node = self.sentinel
        i = 0
        while i <= index:
            node = node.next
            if node == self.sentinel:
                break
            i += 1
        if node == self.sentinel:
            node = None
        return node

    def __getitem__(self, index):
        node = self.get_node(index)
        return node.value

    def __len__(self):
        return self.__len

    def __setitem__(self, index, value):
        node = self.get_node(index)
        node.value = value

    def __delitem__(self, index):
        node = self.get_node(index)
        if node:
            node.prev.next = node.next
            if node.next:
                node.next.prev = node.prev
            node.prev = None
            node.next = None
            node.value = None
            self.__len -= 1

    def __repr__(self):
        return str(self.to_list())

    def to_list(self):
        elts = []
        curr = self.sentinel.next
        while curr != self.sentinel:
            elts.append(curr.value)
            curr = curr.next
        return elts

    def append(self, value):
        node = Node(value)
        self.insert_between(node, self.sentinel.prev, self.sentinel)

    def appendleft(self, value):
        node = Node(value)
        self.insert_between(node, self.sentinel, self.sentinel.next)

    def insert(self, index, value):
        new_node = Node(value)
        len_ = len(self)
        if len_ == 0:
            self.insert_between(new_node, self.sentinel, self.sentinel)
        elif index >= 0 and index < len_:
            node = self.get_node(index)
            self.insert_between(new_node, node.prev, node)
        elif index == len_:
            self.insert_between(new_node, self.sentinel.prev, self.sentinel)
        else:
            raise IndexError

    def insert_between(self, node, left_node, right_node):
        if node and left_node and right_node:
            node.prev = left_node
            node.next = right_node
            left_node.next = node
            right_node.prev = node
            self.__len += 1
        else:
            raise IndexError

    def insert_after(self, node, value):
        new_node = Node(value)
        node.next.prev = new_node
        new_node.next = node.next
        node.next = new_node
        new_node.prev = node
        self.__len += 1

    def merge_left(self, other):
        self.sentinel.next.prev = other.sentinel.prev
        other.sentinel.prev.next = self.sentinel.next
        self.sentinel.next = other.sentinel.next
        self.sentinel.next.prev = self.sentinel
        self.__len += other.__len

    def merge_right(self, other):
        self.sentinel.prev.next = other.sentinel.next
        other.sentinel.next.prev = self.sentinel.prev
        self.sentinel.prev = other.sentinel.prev
        self.sentinel.prev.next = self.sentinel
        self.__len += other.__len

    def pop(self, node = None):
        if node is None:
            node = self.sentinel.prev
        if self.__len < 1:
            raise IndexError
        node.prev.next = node.next
        node.next.prev = node.prev
        self.__len -= 1
        return node.value

    def before(self, node):
        return node.prev.prev if node.prev == self.sentinel else node.prev

    def after(self, node):
        return node.next.next if node.next == self.sentinel else node.next

class LazySegmentTree:
    def __init__(self, data, default=0, func=max):
        """initialize the lazy segment tree with data"""
        self._default = default
        self._func = func

        self._len = len(data)
        self._size = _size = 1 << (self._len - 1).bit_length()
        self._lazy = [0] * (2 * _size)

        self.data = [default] * (2 * _size)
        self.data[_size:_size + self._len] = data
        for i in reversed(range(_size)):
            self.data[i] = func(self.data[i + i], self.data[i + i + 1])

    def __len__(self):
        return self._len

    def _push(self, idx):
        """push query on idx to its children"""
        # Let the children know of the queries
        q, self._lazy[idx] = self._lazy[idx], 0

        self._lazy[2 * idx] += q
        self._lazy[2 * idx + 1] += q
        self.data[2 * idx] += q
        self.data[2 * idx + 1] += q

    def _update(self, idx):
        """updates the node idx to know of all queries applied to it via its ancestors"""
        for i in reversed(range(1, idx.bit_length())):
            self._push(idx >> i)

    def _build(self, idx):
        """make the changes to idx be known to its ancestors"""
        idx >>= 1
        while idx:
            self.data[idx] = self._func(self.data[2 * idx], self.data[2 * idx + 1]) + self._lazy[idx]
            idx >>= 1

    def add(self, start, stop, value):
        """lazily add value to [start, stop)"""
        start = start_copy = start + self._size
        stop = stop_copy = stop + self._size
        while start < stop:
            if start & 1:
                self._lazy[start] += value
                self.data[start] += value
                start += 1
            if stop & 1:
                stop -= 1
                self._lazy[stop] += value
                self.data[stop] += value
            start >>= 1
            stop >>= 1

        # Tell all nodes above of the updated area of the updates
        self._build(start_copy)
        self._build(stop_copy - 1)

    def query(self, start, stop, default=0):
        """func of data[start, stop)"""
        start += self._size
        stop += self._size

        # Apply all the lazily stored queries
        self._update(start)
        self._update(stop - 1)

        res = default
        while start < stop:
            if start & 1:
                res = self._func(res, self.data[start])
                start += 1
            if stop & 1:
                stop -= 1
                res = self._func(res, self.data[stop])
            start >>= 1
            stop >>= 1
        return res

    def __repr__(self):
        return "LazySegmentTree({0})".format(self.data)

class FenwickTree:
    def __init__(self, x):
        """transform list into BIT"""
        self.bit = x
        for i in range(len(x)):
            j = i | (i + 1)
            if j < len(x):
                x[j] += x[i]

    def update(self, idx, x):
        """updates bit[idx] += x"""
        while idx < len(self.bit):
            self.bit[idx] += x
            idx |= idx + 1

    def query(self, end):
        """calc sum(bit[:end])"""
        x = 0
        while end:
            x += self.bit[end - 1]
            end &= end - 1
        return x

    def findkth(self, k):
        """Find largest idx such that sum(bit[:idx]) <= k"""
        idx = -1
        for d in reversed(range(len(self.bit).bit_length())):
            right_idx = idx + (1 << d)
            if right_idx < len(self.bit) and k >= self.bit[right_idx]:
                idx = right_idx
                k -= self.bit[idx]
        return idx + 1






# region fastio

BUFSIZE = 8192


class FastIO(IOBase):
    newlines = 0

    def __init__(self, file):
        self._file = file
        self._fd = file.fileno()
        self.buffer = BytesIO()
        self.writable = "x" in file.mode or "r" not in file.mode
        self.write = self.buffer.write if self.writable else None

    def read(self):
        while True:
            b = os.read(self._fd, max(os.fstat(self._fd).st_size, BUFSIZE))
            if not b:
                break
            ptr = self.buffer.tell()
            self.buffer.seek(0, 2), self.buffer.write(b), self.buffer.seek(ptr)
        self.newlines = 0
        return self.buffer.read()

    def readline(self):
        while self.newlines == 0:
            b = os.read(self._fd, max(os.fstat(self._fd).st_size, BUFSIZE))
            self.newlines = b.count(b"\n") + (not b)
            ptr = self.buffer.tell()
            self.buffer.seek(0, 2), self.buffer.write(b), self.buffer.seek(ptr)
        self.newlines -= 1
        return self.buffer.readline()

    def flush(self):
        if self.writable:
            os.write(self._fd, self.buffer.getvalue())
            self.buffer.truncate(0), self.buffer.seek(0)


class IOWrapper(IOBase):
    def __init__(self, file):
        self.buffer = FastIO(file)
        self.flush = self.buffer.flush
        self.writable = self.buffer.writable
        self.write = lambda s: self.buffer.write(s.encode("ascii"))
        self.read = lambda: self.buffer.read().decode("ascii")
        self.readline = lambda: self.buffer.readline().decode("ascii")


sys.stdin, sys.stdout = IOWrapper(sys.stdin), IOWrapper(sys.stdout)
input = lambda: sys.stdin.readline().rstrip("\r\n")

# endregion

if __name__ == "__main__":

    main()