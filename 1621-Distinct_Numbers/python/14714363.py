length = int(input())
numbers = list(map(int, input().split()))

numbers.sort()

def find_distinct(nums):
    return len(set(numbers))

print(find_distinct(numbers)) 