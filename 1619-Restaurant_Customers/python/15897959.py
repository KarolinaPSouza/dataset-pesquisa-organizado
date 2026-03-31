import heapq
def solve():
    import sys
    data = sys.stdin.read().split()

    n = int(data[0])
    intervals = []
    idx = 1
    for _ in range(n):
        a = int(data[idx])
        b = int(data[idx + 1])
        intervals.append((a,b))
        idx += 2
    intervals.sort()
    res = 0
    heap = []
    for start, end in intervals:
        if heap and start >= heap[0]:
            heapq.heappushpop(heap,end)
        else:
            heapq.heappush(heap, end)
        res = max(res, len(heap))
    print(res)



if __name__ == '__main__':
    solve()

