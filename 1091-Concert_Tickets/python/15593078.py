import sys
import math, bisect
_ = list(map(int, input().split()))
tickets = list(map(int, input().split()))
customer_prices = list(map(int, input().split()))

bucket_count = 10
buckets = [[] for _ in range(bucket_count)]
max_ticket = max(tickets)
range_end = max_ticket + 1


for ticket in tickets:
 # percent_of_range = ticket/range_end
 # bucket_index = math.floor(percent_of_range * bucket_count)
 bucket_width = range_end/bucket_count
 gap_from_min = ticket
 bucket_index = math.floor(gap_from_min/bucket_width)
 buckets[bucket_index].append(ticket)

for bucket in buckets:
 bucket.sort()

for customer_price in customer_prices:

 # percent_of_range = customer_price/range_end
 # bucket_index = min(math.floor(percent_of_range * bucket_count), bucket_count - 1)
 gap_from_min = customer_price
 bucket_index = min(math.floor(gap_from_min/bucket_width), bucket_count - 1)
 for candidate_index in range(bucket_index, -1, -1):
  candidate_bucket = buckets[candidate_index]
  candidate = bisect.bisect_right(candidate_bucket, customer_price) - 1
  if 0 <= candidate <= len(candidate_bucket) - 1 and candidate_bucket[candidate] <= customer_price:
   print(candidate_bucket[candidate])
   candidate_bucket.pop(candidate)
   break
 else:
  print(-1)

