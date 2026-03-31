# def count(count_of_customers: int):
#   customers = []

#   for i in range(2*count_of_customers):
#     input_item = int(input())
#     customers.append(input_item)

#   arrival = sorted([customers[i] for i in range(0, len(customers), 2)])
#   departure = sorted([ customers[i] for i in range(1, len(customers), 2) ])

#   n = len(arrival)
#   i = 0
#   j = 0
#   current_customers = 0
#   max_customers = 0

#   while i < n and j < n:
#     if arrival[i] < departure[j]:
#       current_customers += 1
#       i += 1
#     else:
#       current_customers -= 1
#       j += 1
#     max_customers = max(max_customers, current_customers)

#   return max_customers

import sys

input_data = sys.stdin.read().split()
count_of_customers = int(input_data[0])

# Parse arrival and departure times
customers = list(map(int, input_data[1:]))  # Read all numbers as a list
arrival = sorted(customers[0::2])  # Extract and sort arrival times
departure = sorted(customers[1::2])  # Extract and sort departure times

# Two-pointer approach to track max customers in the shop
n = count_of_customers
i = 0
j = 0
current_customers = 0
max_customers = 0

while i < n and j < n:
    if arrival[i] < departure[j]:
        current_customers += 1
        i += 1
    else:
        current_customers -= 1
        j += 1
    max_customers = max(max_customers, current_customers)

# Print the maximum number of customers present at the same time
print(max_customers)