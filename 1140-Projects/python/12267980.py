n = int(input())

important_days = {}
for i in range(n):
    start_day, finish_day, reward = map(int, input().split())
    if finish_day + 1 not in important_days:
        important_days[finish_day + 1] = [(start_day, reward)]
    else:
        important_days[finish_day + 1].append((start_day, reward))
    if start_day not in important_days:
        important_days[start_day] = []
order = {}
cur = 1
for day in sorted(important_days.keys()):
    order[day] = cur
    cur += 1

max_reward = [0] * cur
for i, day in enumerate(order.keys(), 1):
    if max_reward[i] == 0:
        max_reward[i] = max_reward[i - 1]
    for start_day, reward in important_days[day]:
        max_reward[i] = max(max_reward[i], max_reward[order[start_day]] + reward)
print(max_reward[-1])


