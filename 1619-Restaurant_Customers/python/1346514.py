from collections import defaultdict
times = defaultdict(int)
for _ in range(int(input())):
    a, b = map(int, input().split())
    times[a] += 1
    times[b] -= 1
highest_chance_of_getting_corona = 0
chance_of_getting_corona = 0
for time in sorted(times.keys()):
    chance_of_getting_corona += times[time]
    if chance_of_getting_corona > highest_chance_of_getting_corona:
        highest_chance_of_getting_corona = chance_of_getting_corona
print(highest_chance_of_getting_corona)