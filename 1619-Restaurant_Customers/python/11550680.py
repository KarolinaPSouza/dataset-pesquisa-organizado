from collections import defaultdict
n = int(input())
times = set()
events = defaultdict(int)
for i in range(n):
    a,b=map(int,input().split())
    times.add(a)
    times.add(b)
    events[a]+=1
    events[b]-=1
times = sorted(times)
max_count = 0  # Maximum number of customers at any time
current_count = 0  # Current number of customers
for time in times:
    current_count += events[time]
    max_count = max(max_count, current_count)


print(max_count)  # Output: 2