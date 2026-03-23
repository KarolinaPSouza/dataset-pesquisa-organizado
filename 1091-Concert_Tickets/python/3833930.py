# Import helpful pages
from sys import stdin, stdout
from collections import defaultdict
import copy
import math
import bisect
import itertools

# Helper methods for execution
def read_strs(read_n=True):
  n = int(stdin.readline())
  return [stdin.readline() for i in range(n)]


def read_ints(read_n=True, n=1):
  if read_n:
    n = int(stdin.readline())
  return [int(stdin.readline()) for i in range(n)]

def read_int_list(read_n=True, n=1):
  if read_n:
    n = int(stdin.readline())
  def read_len_list():
    l = int(stdin.readline())
    return [int(i) for i in stdin.readline().split()]
  return [read_len_list() for i in range(n)]

def _get_str_list(str):
  return [str[i] for i in range(len(str))]

def write_out(value):
  stdout.write(str(value))


def write_line(value):
  stdout.write(str(value) + '\n')

COMMENTS_ON = True

def comment(value):
  if COMMENTS_ON:
    stdout.write(str(value) + '\n')

def execute_on_input(handle_input, get_input=read_strs):
  for eval in [handle_input(input) for input in get_input()]:
    write_line(eval)


def puzzle():
  def read():
    return [tuple([int(i) for i in stdin.readline().split()]) for j in range(int(stdin.readline()))]

  def single_int():
    return int(stdin.readline())

  def single_str():
    return stdin.readline()

  def calc(input):
    return len(input)

  total_tickets, total_customers = tuple([ int(i) for i in stdin.readline().split()])
  tickets = [ int(i) for i in stdin.readline().split()]
  tickets.sort()
  customers = [ int(i) for i in stdin.readline().split()]
  total_tickets, total_customers = len(tickets), len(customers)

  unhappy_match_min = max(0, total_customers - total_tickets)

  nexts = list(range(total_tickets))

  for i in range(total_customers):
    bid = customers[i]
    loc = min(bisect.bisect_right(tickets, bid), total_tickets - 1)
    if tickets[loc] > bid:
      loc -= 1

    while loc != nexts[loc] and loc >= 0:
      next_loc = nexts[loc]
      if next_loc != -1:
        nexts[loc] = nexts[next_loc]
      loc = next_loc

    if loc == -1:
      write_line(-1)
      unhappy_match_min -= 1
    else:
      write_line(tickets[loc])
      if loc > 0:
        nexts[loc] = nexts[loc - 1]
      else:
        nexts[loc] = -1

  for i in range(max(unhappy_match_min, 0)):
    write_line(-1)

  return 

  # input = [stdin.readline() for i in range(8)]
  # write_line(calc(input))
  # write_line(calc(read_int_list(read_n=False)[0]))
  # execute_on_input(calc, read_int_list(read_n=False))

# Call the methods
if __name__ == "__main__":
  puzzle()