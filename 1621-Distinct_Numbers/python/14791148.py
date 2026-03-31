import sys
input = sys.stdin.readline

n = int(input())
a = input().split()
unique = set(a)
print(len(unique))