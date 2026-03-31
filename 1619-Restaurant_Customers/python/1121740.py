z = input
d = []
for i in range(int(z())):
    x, y = map(int, z().split())
    d.extend([(x<<1), (y<<1|1)])
ac = a = 0
for i in sorted(d):
    ac += -1 if i&1 else 1
    a = max(ac,a)
print(a)