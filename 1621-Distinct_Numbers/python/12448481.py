def fix(x):
    return int(x)+1
input()
s = set(map(fix, input().split()))
print(len(s))