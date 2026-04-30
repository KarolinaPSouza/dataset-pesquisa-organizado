import sys
 
# Increase recursion depth for safety, though we use an iterative approach
sys.setrecursionlimit(300000)
 
def solve():
    input_data = sys.stdin.read().split()
    if not input_data:
        return
    
    n = int(input_data[0])
    k = int(input_data[1])
    
    movies = []
    coords = set()
    # Add 0 as a starting time for all members
    coords.add(0)
    
    idx = 2
    for _ in range(n):
        s = int(input_data[idx])
        e = int(input_data[idx+1])
        movies.append((s, e))
        coords.add(s)
        coords.add(e)
        idx += 2
        
    # Sort by end time
    movies.sort(key=lambda x: x[1])
    
    # Coordinate compression
    sorted_coords = sorted(list(coords))
    rank = {val: i + 1 for i, val in enumerate(sorted_coords)}
    m = len(sorted_coords)
    
    # Fenwick Tree to store counts of members finishing at specific compressed times
    bit = [0] * (m + 1)
    
    def update(i, delta):
        while i <= m:
            bit[i] += delta
            i += i & (-i)
            
    def query(i):
        s = 0
        while i > 0:
            s += bit[i]
            i -= i & (-i)
        return s
 
    def find_best_member(start_rank):
        """Finds the largest rank <= start_rank that has a member count > 0."""
        total_in_range = query(start_rank)
        if total_in_range == 0:
            return -1
        
        # Binary lifting on Fenwick Tree to find the highest index with prefix sum < total_in_range
        # This finds the last position that contributed to the total_in_range count
        pos = 0
        current_sum = 0
        for i in range(m.bit_length() - 1, -1, -1):
            next_pos = pos + (1 << i)
            if next_pos <= m and current_sum + bit[next_pos] < total_in_range:
                pos = next_pos
                current_sum += bit[pos]
        return pos + 1
 
    # Initially, all k members are free at time 0 (rank[0] = 1)
    update(rank[0], k)
    
    ans = 0
    for s, e in movies:
        s_rank = rank[s]
        e_rank = rank[e]
        
        member_rank = find_best_member(s_rank)
        
        if member_rank != -1:
            # Reassign this member from their old finish time to the new finish time
            update(member_rank, -1)
            update(e_rank, 1)
            ans += 1
            
    sys.stdout.write(str(ans) + '\n')
 
if __name__ == "__main__":
    solve()