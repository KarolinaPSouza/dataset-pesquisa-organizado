n, x = map(int, input().split())
arr = list(map(int, input().split()))

mid = n // 2
left = arr[:mid]
right = arr[mid:]

left_sums = [0]
for num in left:
    new_sums = []
    for s in left_sums:
        new_sums.append(s + num)
    left_sums.extend(new_sums)

right_counts = {0: 1}
for num in right:
    new_counts = {}
    for s, cnt in right_counts.items():
        new_sum = s + num
        new_counts[new_sum] = new_counts.get(new_sum, 0) + cnt
    for s, cnt in new_counts.items():
        right_counts[s] = right_counts.get(s, 0) + cnt

count = 0
for s in left_sums:
    target = x - s
    count += right_counts.get(target, 0)

print(count)
