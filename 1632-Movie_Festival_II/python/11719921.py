from __future__ import annotations
import sys
 
 
def bit_ceil(x: int) -> int:
    """Equivalent of C++'s bit_ceil. Finds smallest power of 2 that is >= x."""
    k = 0
    while (1<<k) < x:
        k += 1
    return 1<<k
 
 
class FenwickTree:
    """Fenwick / binary-indexed tree (BIT).
    
    This data structure allows us to calculate sum(arr[l:r]) in O(log n) for any
    Python list arr comprised of n integers. We can also update the values of
    individual indices of the list in O(log n).
    """
 
    def __init__(self, n: int):
        """Initialises a BIT for a list of length n (initially all zeros)."""
        self.tree = [0] * n
 
    def reset(self) -> None:
        """Resets the BIT to a list of all zeros without changing length."""
        self.tree = [0] * len(self.tree)
 
    def change_value(self, idx: int, delta: int) -> None:
        """Changes the value at the given index of the list by delta."""
        while idx < len(self.tree):
            self.tree[idx] += delta
            idx = idx = idx | (idx + 1)
 
    def sum_indices_up_to(self, idx: int) -> int:
        """Finds the sum of the indices <= idx in the list."""
        ans = 0
        right = idx
        while right >= 0:
            ans += self.tree[right]
            right = (right & (right + 1)) - 1
        return ans
 
    def find_largest_up_to_bound(self, bound: int) -> int | None:
        """Finds largest index such that arr[idx] > 0 and idx <= bound."""
        bound = self.sum_indices_up_to(bound)
        if bound == 0:
            return None
    
        mask = bit_ceil(len(self.tree) - 1)
        index = 0
        while mask > 0:
            new_index = index + mask - 1
            if new_index < len(self.tree) and self.tree[new_index] < bound:
                bound -= self.tree[new_index]
                index += mask
            mask >>= 1
        return index
 
 
num_movies, num_members, *range_values = map(int, sys.stdin.read().split())
 
film_starts = range_values[::2]
film_ends = range_values[1::2]
indices = list(range(num_movies))
indices.sort(key=lambda idx: film_ends[idx])
 
# We compress the coordinates to have smaller BITs.
coordinate_compression = {x: i for i, x in enumerate(sorted(set(range_values)))}
bit = FenwickTree(len(coordinate_compression))
 
num_movies_watched = 0
total_being_watched = 0
for idx in indices:
    start = coordinate_compression[film_starts[idx]]
    end = coordinate_compression[film_ends[idx]]
    previous_film_end = bit.find_largest_up_to_bound(start)
    if previous_film_end is None:
        if total_being_watched < num_members:
            bit.change_value(end, 1)
            num_movies_watched += 1
            total_being_watched += 1
    else:
        bit.change_value(previous_film_end, -1)
        bit.change_value(end, 1)
        num_movies_watched += 1
 
print(num_movies_watched)