import sys
 
def solve():
    # Fast I/O
    input_data = sys.stdin.read().split()
    if not input_data:
        return
        
    n = int(input_data[0])
    k = int(input_data[1])
    
    movies = []
    idx = 2
    for _ in range(n):
        a = int(input_data[idx])
        b = int(input_data[idx+1])
        movies.append((a, b))
        idx += 2
        
    # Step 1: Sort movies by their end times
    movies.sort(key=lambda x: x[1])
    
    # Step 2: Coordinate Compression
    times = {0}
    for a, b in movies:
        times.add(a)
        times.add(b)
        
    sorted_times = sorted(list(times))
    M = len(sorted_times)
    
    # Map each actual time to a 1-based index for the Fenwick Tree
    rank = {t: i + 1 for i, t in enumerate(sorted_times)}
    
    # Step 3: Fenwick Tree (Binary Indexed Tree) Setup
    bit = [0] * (M + 1)
    
    def update(i, delta):
        while i <= M:
            bit[i] += delta
            i += i & (-i)
            
    def query(i):
        s = 0
        while i > 0:
            s += bit[i]
            i -= i & (-i)
        return s
        
    # Precalculate the highest power of 2 for BIT lifting
    max_pow = 1
    while max_pow <= M:
        max_pow <<= 1
    max_pow >>= 1
    
    # Initially, all 'k' members are free at time 0
    update(rank[0], k)
    
    watched = 0
    
    # Step 4: Process the movies
    for a, b in movies:
        r_a = rank[a]
        
        # S is the total number of members available at or before the movie starts
        S = query(r_a)
        
        if S > 0:
            # BIT Lifting: Find the exact rank of the S-th available member.
            # This directly finds the largest available time <= a.
            curr_idx = 0
            curr_sum = 0
            
            step = max_pow
            while step > 0:
                next_idx = curr_idx + step
                # If adding this step keeps us strictly below S, we take the step
                if next_idx <= M and curr_sum + bit[next_idx] < S:
                    curr_idx = next_idx
                    curr_sum += bit[next_idx]
                step >>= 1
                
            # The bucket containing the S-th member is one step past curr_idx
            best_idx = curr_idx + 1
            
            # Assign the movie: remove member from old time, add to new end time
            update(best_idx, -1)
            update(rank[b], 1)
            watched += 1
            
    print(watched)
 
if __name__ == '__main__':
    solve()