def sol():
    n = int(input())
    events = []

    for _ in range(n):
        start, end = map(int, input().strip().split())
        events.append((start, 1))
        events.append((end + 1, -1))

    count_map = {}

    for time, delta in events:
        if time in count_map:
            count_map[time] += delta
        else:
            count_map[time] = delta

    curr = maxi = 0
    for time in sorted(count_map):
        curr += count_map[time]
        maxi = max(maxi, curr)

    return maxi

print(sol())