# stdin =  open('testdata.txt')

# def input():
#  return stdin.readline().strip()


def solve(n, lst):
 lst.sort()
 count = 1
 for i in range(n-1):
  if lst[i] != lst[i+1]:
   count += 1
 print(count)

n = int(input())
lst = list(map(int, input().split()))
solve(n, lst)
















