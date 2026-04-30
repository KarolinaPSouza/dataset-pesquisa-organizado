import sys
import heapq
 
def solve():
    # Use fast I/O
    input_data = sys.stdin.read().split()
    if not input_data:
        return
    
    it = iter(input_data)
    n = int(next(it))
    k = int(next(it))
    
    movies = []
    for _ in range(n):
        s = int(next(it))
        e = int(next(it))
        movies.append((e, s))
    
    # Sort by end time
    movies.sort()
    
    # members_heap stores the end times of movies members are currently watching
    members_heap = []
    count = 0
    
    for end, start in movies:
        # If there is a member who finished before this movie starts
        # We need the one who finished LATEST among those available.
        # However, a simpler greedy approach for this problem:
        # If we have free members, use one. 
        # If not, see if we can replace a member's current movie to finish earlier.
        
        # Standard approach for this specific CP problem (e.g., CSES):
        # We need a data structure that supports 'upper_bound' (like std::multiset in C++).
        # In Python, we can simulate this with two heaps or a SortedList.
        pass
 
# Since standard Python lacks a multiset, here is the most 
# efficient PyPy3-compatible implementation using a Balanced Tree simulation:
 
class SortedList:
    def __init__(self, iterable=[], block_size=700):
        self._len = 0
        self._load = block_size
        self._lists = []
        self._mins = []
        if iterable: self.update(iterable)
 
    def update(self, iterable):
        it = sorted(iterable)
        self._len += len(it)
        self._lists = [it[i:i + self._load] for i in range(0, len(it), self._load)]
        self._mins = [l[0] for l in self._lists]
 
    def add(self, val):
        if not self._lists:
            self._lists = [[val]]
            self._mins = [val]
        else:
            from bisect import bisect_right, insort
            idx = bisect_right(self._mins, val) - 1
            if idx == -1: idx = 0
            insort(self._lists[idx], val)
            self._mins[idx] = self._lists[idx][0]
            if len(self._lists[idx]) > self._load * 2:
                self._lists.insert(idx + 1, self._lists[idx][self._load:])
                self._lists[idx] = self._lists[idx][:self._load]
                self._mins.insert(idx + 1, self._lists[idx + 1][0])
        self._len += 1
 
    def pop_at(self, val_to_find_and_remove):
        from bisect import bisect_right
        idx = bisect_right(self._mins, val_to_find_and_remove) - 1
        if idx < 0: return False
        inner_idx = bisect_right(self._lists[idx], val_to_find_and_remove) - 1
        if inner_idx < 0: return False
        self._lists[idx].pop(inner_idx)
        self._len -= 1
        if not self._lists[idx]:
            self._lists.pop(idx)
            self._mins.pop(idx)
        else:
            self._mins[idx] = self._lists[idx][0]
        return True
 
def final_solve():
    import sys
    input = sys.stdin.read().split()
    if not input: return
    n, k = int(input[0]), int(input[1])
    movies = []
    for i in range(n):
        movies.append((int(input[2*i+3]), int(input[2*i+2])))
    movies.sort()
 
    sl = SortedList([0] * k)
    ans = 0
    for end, start in movies:
        if sl.pop_at(start):
            sl.add(end)
            ans += 1
    print(ans)
 
if __name__ == "__main__":
    final_solve()