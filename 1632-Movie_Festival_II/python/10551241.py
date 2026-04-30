from __future__ import annotations
from bisect import bisect_left, bisect_right
from collections.abc import Iterable, Iterator
 
 
def fenwick_tree(x: list[int]) -> list[int]:
    tree = x.copy()
    for i in range(len(x)):
        j = i | (i + 1)
        if j < len(x):
            tree[j] += tree[i]
    return tree
 
 
def increase(tree: list[int], index: int, x: int):
    while index < len(tree):
        tree[index] += x
        index |= index + 1
 
 
def query(tree: list[int], end: int) -> int:  # [0,end)
    x = 0
    while end:
        x += tree[end - 1]
        end &= end - 1
    return x
 
 
def find_kth(tree: list[int], k: int) -> tuple[int, int]:
    idx = -1
    for d in reversed(range(len(tree).bit_length())):
        right_idx = idx + (1 << d)
        if right_idx < len(tree) and tree[right_idx] <= k:
            idx = right_idx
            k -= tree[idx]
    return idx + 1, k
 
 
class SortedList:
    BLOCK_SIZE = 700
 
    def __init__(self, iterable: Iterable[int] = ()):
        self.macro: list[int] = []
        self.micros: list[list[int]] = [[]]
        self.micro_size = [0]
        self.fenwick = fenwick_tree([0])
        self.size = 0
        for item in iterable:
            self.insert(item)
 
    def insert(self, x: int) -> None:
        i = bisect_left(self.macro, x)
        j = bisect_right(self.micros[i], x)
        self.micros[i].insert(j, x)
        self.size += 1
        self.micro_size[i] += 1
        increase(self.fenwick, i, 1)
        if len(self.micros[i]) >= SortedList.BLOCK_SIZE:
            self.micros[i : i + 1] = (
                self.micros[i][: SortedList.BLOCK_SIZE >> 1],
                self.micros[i][SortedList.BLOCK_SIZE >> 1 :],
            )
            self.micro_size[i : i + 1] = (
                SortedList.BLOCK_SIZE >> 1,
                SortedList.BLOCK_SIZE >> 1,
            )
            self.fenwick = fenwick_tree(self.micro_size)
            self.macro.insert(i, self.micros[i + 1][0])
 
    def pop(self, k: int = -1) -> int:
        i, j = self._find_kth(k)
        self.size -= 1
        self.micro_size[i] -= 1
        increase(self.fenwick, i, -1)
        return self.micros[i].pop(j)
 
    def __getitem__(self, k: int) -> int:
        i, j = self._find_kth(k)
        return self.micros[i][j]
 
    def count(self, x: int) -> int:
        return self.upper_bound(x) - self.lower_bound(x)
 
    def __contains__(self, x: int) -> bool:
        return self.count(x) > 0
 
    def lower_bound(self, x: int) -> int:
        i = bisect_left(self.macro, x)
        return query(self.fenwick, i) + bisect_left(self.micros[i], x)
 
    def upper_bound(self, x: int) -> int:
        i = bisect_right(self.macro, x)
        return query(self.fenwick, i) + bisect_right(self.micros[i], x)
 
    def _find_kth(self, k: int) -> tuple[int, int]:
        return find_kth(self.fenwick, k + self.size if k < 0 else k)
 
    def __len__(self) -> int:
        return self.size
 
    def __iter__(self) -> Iterator[int]:
        return (x for micro in self.micros for x in micro)
 
    def __repr__(self) -> str:
        return str(list(self))
 
readIntArr = lambda: list(map(int, input().split()))
 
INF = 2**32
N, K, *raw = map(int, open(0).read().split())
 
 
# store at what time each member can watch a new film
members = SortedList([0] * K)
 
# store movies
movies: list[int] = []
for i in range(N):
    start = int(raw[i * 2])
    end = int(raw[i * 2 + 1])
    movies.append(end * INF + start)
 
movies.sort()
 
cnt = 0
 
for movie in movies:
    start, end = movie % INF, movie // INF
 
    # find a member that will be free at the start of the movie
    member = members.upper_bound(start) - 1
    if member == -1:
        continue
    
    members.pop(member)
    members.insert(end)
    cnt += 1
 
print(cnt)