import sys

read = sys.stdin.readline

n = int(read())
values = read()
arr = values.split(' ')
arr[len(arr) - 1] = arr[len(arr) - 1].replace('\n', '')

res = [*set(arr)]
print(len(res))