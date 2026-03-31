import sys, heapq

input = sys.stdin.readline


def restaurant_customers():
    n = int(input())

    times = []
    for _ in range(n):
        start, end = map(int, input().split())
        times.append((start, end))
    times.sort()

    pq = []
    max_customers = 0
    for i in range(n):
        if pq and pq[0] <= times[i][0]:
            heapq.heappop(pq)
        heapq.heappush(pq, times[i][1])
        max_customers = max(max_customers, len(pq))
    print(max_customers)


if __name__ == "__main__":
    restaurant_customers()