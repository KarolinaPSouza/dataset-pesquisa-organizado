n, m, k = map(int, input().split())

desired_size = sorted([int(i) for i in input().split()])
real_size = sorted([int(i) for i in input().split()])

i, j = 0, 0
ans = 0

while i < n and j < m:

    if real_size[j] > desired_size[i] + k:
        i += 1

    elif real_size[j] < desired_size[i] - k:
        j += 1

    else:
        ans += 1
        i += 1
        j += 1

print(ans)