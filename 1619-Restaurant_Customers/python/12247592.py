starts = {}
ends = {}
total = set()
ls =[]
for q in range(int(input())):
    a, b = map(int, input().split())
    if a in starts:
        starts[a] += 1
    else:
        starts[a] = 1
    if b in ends:
        ends[b] += 1
    else:
        ends[b] = 1
    if a not in total:
        ls.append(a)
    if b not in total:
        ls.append(b)
    total.add(a)
    total.add(b)
prefix = [0 for i in range(len(total))]
ls.sort()
for ind, i in enumerate(ls):
    if i in starts:
        prefix[ind] += starts[i]
    if i in ends:
        prefix[ind] -= ends[i]
for i in range(1, len(prefix)):
    prefix[i] = prefix[i] + prefix[i-1]
print(max(prefix))