n, x = map(int, input().split())
h = list(map(int, input().split()))
s = list(map(int, input().split()))

result = [0] * (x + 1)

for hi, si in zip(h, s):
    result = [
        max((result[i - hi] + si if i >= hi else 0), result[i]) for i in range(0, x + 1)
    ]

print(max(result))