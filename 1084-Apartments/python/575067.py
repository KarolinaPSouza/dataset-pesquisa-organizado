#!/usr/bin/python
# -*- coding: UTF-8 -*-
#------------------------------*
# Author: Arijit Dasgupta      |
# Email: arijit.dg@hotmail.com |
#------------------------------*

int_list = [int(x) for x in input().split()]
n, m, k = int_list[0], int_list[1], int_list[2]

desired_sizes = sorted([int(x) for x in input().split()])
actual_sizes = sorted([int(x) for x in input().split()])

apt_idx = 0
apt_sold = 0

for i in range(n):
 if apt_idx == m:
  break
 while True:
  if actual_sizes[apt_idx] + k < desired_sizes[i]:
   if apt_idx == m-1:
    break
   else:
    apt_idx += 1 
  elif desired_sizes[i] <= k + actual_sizes[apt_idx] and desired_sizes[i] >= actual_sizes[apt_idx] - k:
   apt_sold += 1
   apt_idx += 1
   break
  else:
   break


print(apt_sold)
