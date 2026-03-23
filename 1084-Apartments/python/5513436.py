#!/usr/bin/env python
# -*- coding: utf-8 -*-

n, m, k = map(int, input().split())

Applicants = list(map(int, input().split()))

Apartments = list(map(int, input().split()))

Applicants.sort()
Apartments.sort()

def totalMatches():

 if len(Apartments) == 0 or len(Applicants) == 0:
  return 0

 total, i, j = 0, 0, 0
 applicant = Applicants[0]
 apartment = Apartments[0]

 while True:
  if abs(applicant - apartment) <= k:
   total += 1
   i += 1
   j += 1

   if i < n:
    applicant = Applicants[i]
   else:
    break

   if j < m:
    apartment = Apartments[j]
   else:
    break
  else:

   if apartment - applicant > k:
    i += 1

    if i < n:
     applicant = Applicants[i]
    else:
     break

   else:
    j += 1

    if j < m:
     apartment = Apartments[j]
    else:
     break

 return total

print(totalMatches())