from collections import defaultdict

def max_customers(n, times):
    timeline = defaultdict(int)

    for a, b in times:
        timeline[a] += 1
        timeline[b] -= 1

    current = 0
    max_count = 0

    for time in sorted(timeline.keys()):
        current += timeline[time]
        max_count = max(max_count, current)

    return max_count

# --------- Input Handling ---------
if __name__ == "__main__":
    import sys
    input = sys.stdin.read
    data = input().split()

    n = int(data[0])
    times = []
    index = 1
    for _ in range(n):
        a = int(data[index])
        b = int(data[index + 1])
        times.append((a, b))
        index += 2

    print(max_customers(n, times))