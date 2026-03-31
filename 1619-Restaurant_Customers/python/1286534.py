# -*- coding: utf-8 -*-
"""
Created on Mon Nov 23 20:40:13 2020
 @author: macal
"""

n = eval(input())

enter = []
leave = []

for i in range(n):
  a, b = map(int, input().split()) 
  enter.append(a)
  leave.append(b)

enter.sort()
leave.sort()

i = j = 0
current = 0
answer = 0

while i<n and j<n:
  if enter[i] < leave[j]:
    current += 1
    i += 1
  else:
    current -= 1
    j += 1
  if current > answer:
    answer = current

print(answer)    
