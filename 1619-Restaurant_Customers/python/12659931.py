# n = int(input(" Enter a number: "))
# while n!=1:
#     print(n, end=" ")
#     if n%2==0:
#         n = n//2
#     else:
#         n = (3*n + 1)
# print(n, end=" ")

# n = int(input())

# num = list(map(int,input().split()))

# print((n*(n+1)//2)-sum(num))
# print((n * (n + 1) // 2) - sum(num))



# def moves_difference(n,list1):
#     moves = 0
#     for i in range(n-1):
#         if list1[i]>list1[i+1]:
#             difference = list1[i] - list1[i+1]
#             moves += difference
#             list1[i+1] += difference
#     return moves


# n=int(input())
# list1=list(map(int,input().split()))


# print(moves_difference(n,list1))


# def permutation(n):
#     if n > 1 and n < 4:
#         return "NO SOLUTION"
#     else:
#         if n % 2 == 0:
#             for i in range(2, n+1, 2):
#                 print(i, end=" ")
#             for i in range(1, n+1, 2):
#                 print(i, end=" ")


# n = int(input())

# if n == 2 or n == 3:
#     print("NO SOLUTION")
# else:
#     for i in range(2, n+1, 2):
#         print(i, end=' ')
#     for i in range(1, n+1, 2):
#         print(i, end=' ')

# n = int(input())
# print(permutation(n))

# for y in range(int(input())):
#     a,b=map(int,input().split())
#     maxx=max(a,b)
#     t=(maxx-1)**2
#     if t%2==0:
#         t=t+b+(maxx-a)
#     else:
#         t=t+maxx-b+a
#     print(t)

# n = 7#int(input())

# # Check if it is possible to split by checking if the summation to n is even
# s = (n * (n + 1)) // 2

# if s % 2 == 0:
#     subset_sum = s // 2
#     # Possible
#     a = set()
#     b = set()
#     for i in range(n, 0, -1):
#         if i <= subset_sum:
#             subset_sum -= i
#             a.add(i)
#         else:
#             b.add(i)

#     print("YES")
#     print(len(a))
#     print(*a)
#     print(len(b))
#     print(*b)

# else:
#     print("NO")



# n = int(input())
# for k in range(1, n + 1):
#     total = (k * k) * (k * k - 1) // 2
#     if k > 2:
#         total -= 4 * (k - 1) * (k - 2)
#     print(total)

# def count_trailing_zeros(n):
#     zeros = 0
#     print(n)
#     while n >= 5:
#         n //= 5
#         print(n)
#         zeros += n

#     return zeros

# # Example usage
# n = int(input())
# result = count_trailing_zeros(n)
# print(result)

# for i in range(int(input())):
#     a,b = map(int, input().split())
#     if (a+b)%3==0 and min(a,b)*2>=max(a,b):
#         print("YES")
#     else:
#         print("NO")

# s = input()
# pairs = []
# single = []

# for char in s:
#     if char in single:
#         single.remove(char)
#         pairs.append(char)
#     else:
#         single.append(char)

# res = ''.join(pairs) + ''.join(single) + ''.join(pairs)[::-1]

# if res == res[::-1]:
#     print(res)
# else:
#     print("NO SOLUTION")


# n = 5#int(input())

# print(2**n)

# def gray_code(n):
#     gray = ['0', '1']
#     print('The original gray code is:', gray)
#     for i in range(2, n+1):
#         reflected = gray[::-1]
#         print('The reflected gray code is:', reflected)
#         print('The original gray code is:', gray)
#         # print(reflected)
#         gray = ['0' + code for code in gray] + ['1' + code for code in reflected]
#         print(f"this is iteration {i}",gray)
#     return gray

# # Handle base case
# if n == 1:
#     print("0\n1")
# else:
#     result = gray_code(n)
#     for code in result:
#         print(code)

# apples = [3,2,7,4,1]#list(map(int, input().split()))

# sum = sum(apples)
# print(sum)
# c = sum//2
# g1 = []
# g2=[]
# for i in range(c+1,0,-1):
#     if i <= c:
#         c-=i
#         g1.append(i)
#     else:
#         g2.append(i)
# print(g1)
# print(g2)

# number, capacity = map(int, input().split())
# weights = list(map(int, input().split()))

# def min_gondolas(n, x, weights):
#     weights.sort()
#     i, j = 0, n - 1
#     count = 0

#     while i <= j:
#         if weights[i] + weights[j] <= x:
#             i += 1
#         j -= 1
#         count += 1

#     return count

# print(min_gondolas(number, capacity, weights))


# n = int(input())
# a = list(map(int, input().split()))
# b = set()
# c=0
# for num in a:
#     if num in b:
#         b.remove(num)
#     else:
#         b.add(num)
#         c+=1
# print(len(b))


# n,m = 5 ,3
# tickets = [5,3,7,8,5]
# customers = [4,8,3]

# n, m = map(int, input().split())
# tickets = list(map(int, input().split()))
# customers = list(map(int, input().split()))

# for t in customers:
#     best = -1
#     idx = -1
#     for i in range(len(tickets)):
#         if tickets[i] <= t and tickets[i] > best:
#             best = tickets[i]
#             idx = i
#     if idx != -1:
#         print(tickets[idx])
#         tickets.pop(idx)
#     else:
#         print(-1)


# n = int(input())   
# customer = []
# for i in range(n):
#     a,b = map(int, input().split())
#     customer.append((a,1))
#     customer.append((b,-1))
# c = 0
# cus = 0
# for c,p in customer:
#     c += p
#     print('this',c,p)
#     cus = max(cus,c)
# print(cus)

import sys

n = int(input())
events = []

for _ in range(n):
    a, b = map(int,sys.stdin.readline().split())
    events.append((a, 1))  # arrival = +1
    events.append((b, -1))  # departure = -1

events.sort()
# print(events)

current = 0
max_customers = 0

for time, change in events:
    current += change
    max_customers = max(max_customers, current)

print(max_customers)

