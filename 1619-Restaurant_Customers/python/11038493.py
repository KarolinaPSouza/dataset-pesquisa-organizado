from collections import defaultdict, OrderedDict, Counter
from itertools import permutations, combinations
import math
from pprint import pprint 
# from queue import PriorityQueue
import threading
import sys
from bisect import bisect_left, bisect_right
from heapq import heappush, heappop


# MOD = 998244353  
MOD = 10**9 + 7

sys.setrecursionlimit(10**5)
threading.stack_size(10**6)
input = sys.stdin.readline
flush = sys.stdout.flush

def lower_bound(nums, target):
    l, r = 0, len(nums) - 1
    while l <= r:
        mid = l + (r - l) // 2
        if nums[mid] >= target:
            r = mid - 1
        else:
            l = mid + 1
    return l

def upper_bound(nums, target):
    l, r = 0, len(nums) - 1
    while l <= r:
        mid = l + (r - l) // 2
        if nums[mid] > target:
            r = mid - 1
        else:
            l = mid + 1
    return r

def find_prime_factors(n):
    factors = defaultdict(int)
    divisor = 2

    while divisor <= n:
        if n % divisor == 0:
            factors[divisor] += 1
            n = n / divisor
        else:
            divisor += 1

    return factors

def find_divisors(n):
    sqrt = math.isqrt(n)
    divs = []
    for div in range(1, sqrt+1):
        if n % div == 0:
            divs.append(div)
            if div != n // div:
                divs.append(n // div)

    # divs.sort()        
    return divs

def is_prime(n):
    sq = math.isqrt(n)
    for div in range(2, sq+1):
        if n % div == 0:
            return False
    return True

def soe(start, limit):
    # Initialize a boolean array to mark prime numbers
    is_prime = [True] * (limit + 1)
    is_prime[0] = is_prime[1] = False  # 0 and 1 are not primes

    # Perform Sieve of Eratosthenes
    for i in range(2, math.isqrt(limit) + 1):
        if is_prime[i]:
            for j in range(i * i, limit + 1, i):
                is_prime[j] = False

    # Collect primes within the specified range
    primes = []
    for i in range(start, limit + 1):
        if is_prime[i]:
            primes.append(i)

    return primes


def ceil_division(a, b):
    return (a+b-1)//b

def get_triangle_area(x, y):
    area = 0.5 * (x[0] * (y[1] - y[2]) + x[1] * (y[2] - y[0]) + x[2] * (y[0] - y[1]))
    return area

def prefix_sum(arr):
    prx = []
    cur = 0
    for num in arr:
        cur += num
        prx.append(cur)
    return prx

def prefix_max(arr):
    prx = []
    mx = float("-inf")
    for num in arr:
        mx = max(mx, num)
        prx.append(mx)
    return prx

def prefixSum2D(a, R, C):
    psa = [[0 for x in range(C)] for y in range(R)]
    psa[0][0] = a[0][0]

    for i in range(1, C):
        psa[0][i] = (psa[0][i - 1] + a[0][i])
    for i in range(0, R):
        psa[i][0] = (psa[i - 1][0] + a[i][0])

    for i in range(1, R):
        for j in range(1, C):
            psa[i][j] = (psa[i - 1][j] + psa[i][j - 1] - psa[i - 1][j - 1] + a[i][j])
    return psa

def sum_interval_2d(prx, row1, col1, row2, col2):
    to_remove_first = prx[row1 - 1][col2] if row1 > 0 else 0
    to_remove_second = prx[row2][col1 - 1] if col1 > 0 else 0
    common = prx[row1 - 1][col1 - 1] if (row1 > 0 and col1 > 0) else 0
    return prx[row2][col2] - to_remove_first - to_remove_second + common


def sum_interval(prx, start, end):
    if start > end: return 0
    return prx[end] - prx[start-1] if start > 0 else prx[end]

def quadratic_formula(a, b, c):
    ans1 = (-b + (b**2 - 4*a*c)**0.5) / (2*a)
    ans2 = (-b - (b**2 - 4*a*c)**0.5) / (2*a)
    return ans1, ans2

def is_between(i1, j1, i2, j2, i3, j3):
    collinear = (j2 - j1) * (i3 - i1) == (j3 - j1) * (i2 - i1)

    if not collinear:
        return False

    within_bounds = (min(i1, i3) <= i2 <= max(i1, i3)) and (min(j1, j3) <= j2 <= max(j1, j3))

    return within_bounds

def slope(x1, y1, x2, y2):
    if x2 == x1: return float("inf")
    x = (y2 - y1) / (x2 - x1)
    return x

def get_counts(arr):
    counts = defaultdict(int)
    for num in arr:
        counts[num] += 1
    return counts

def gcd_arr(arr):
    gcd = arr[0]
    for num in arr:
        gcd = math.gcd(gcd, num)
    return gcd

CONST = (1 << 31) - 1

def lcm(*integers):
    a = integers[0]
    for b in integers[1:]:
        a = (a * b) // math.gcd (a, b)
    return a

def get_inverse(n):
    global CONST
    return n ^ CONST

def is_palindrome(arr):
    return arr == arr[::-1]

def is_kalindrome(arr, x, l, r):
    while l <= r:
        if arr[l] == arr[r]:
            l += 1
            r -= 1
        else:
            if arr[l] == x:
                l += 1
            elif arr[r] == x:
                r -= 1
            else:
                return False
    return True

def suffix_sum(arr):
    sm = 0
    ans = []
    rev_arr = arr[::-1]
    for num in rev_arr:
        sm += num
        ans.append(sm)
    return ans[::-1]

def suffix_max(arr):
    mx = float("-inf")
    ans = []
    rev_arr = arr[::-1]
    for num in rev_arr:
        mx = max(mx, num)
        ans.append(mx)

    return ans[::-1]

def kadanes_algo(arr):
    sm = 0
    mx = float("-inf")
    ans = []
    for num in arr:
        sm += num
        if sm < 0:
            sm = 0
        mx = max(mx, sm)
        ans.append(mx)
    return ans

def arithmitic_seq_sum(a, b, n):
    return (n * (a + b)) // 2

def geometric_seq_sum(a, b, r):
    return (b*r - a) // (r - 1)


def find_diff_char(forbidden_chars):
    for char in "abcdefghijklmnopqrstuvwxyz":
        if char not in forbidden_chars:
            return char
    return ""

def mod_inverse_euclidean(a, mod):
    g, x, y = extended_gcd(a, mod)
    if g != 1:
        raise ValueError(f"No modular inverse for {a} under mod {mod}")
    else:
        return x % mod

def extended_gcd(a, b):
    if a == 0:
        return b, 0, 1
    g, x1, y1 = extended_gcd(b % a, a)
    x = y1 - (b // a) * x1
    y = x1
    return g, x, y

def sum_law(n):
    if n <= 0: return 0
    return (n * (n + 1)) // 2

def sum_law_diff(l, r):
    return sum_law(r) - sum_law(l-1)

def factorial(start, n, m):
    while n > 1:
        start *= n
        start %= m
        n -= 1

    return start

def lcm_arr(arr):
    ans = 1
    for num in arr:
        ans = lcm(ans, num)

    return ans

def findProductSum(A, n): 

    # calculating array sum (a1 + a2 ... + an) 
    array_sum = 0
    for i in range(0, n, 1): 
        array_sum = array_sum + A[i] 

    # calculating square of array sum 
    # (a1 + a2 + ... + an)^2 
    array_sum_square = array_sum * array_sum 

    # calculating a1^2 + a2^2 + ... + an^2 
    individual_square_sum = 0
    for i in range(0, n, 1): 
        individual_square_sum += A[i] * A[i] 

    # required sum is (array_sum_square - 
    # individual_square_sum) / 2 
    return (array_sum_square - 
            individual_square_sum) // 2


# found = defaultdict(list)

# N = 1001  # Replace with the desired value of N
# d = [N] * N
# d[1] = 0

# for i in range(1, N):
#     for x in range(1, i + 1):
#         j = i + i // x
#         if j < N:
#             d[j] = min(d[j], d[i] + 1)






# print(costs[:20])

# print(costs[:30])


# def knapsack(k, weights, gains):
#     n = len(weights)
#     # Create a DP table with k+1 capacity (0 to k)
#     dp = [[0] * (k + 1) for _ in range(n + 1)]

#     # Iterate through items
#     for i in range(1, n + 1):
#         for w in range(k + 1):
#             if weights[i-1] <= w:  # If the current item can be included
#                 dp[i][w] = max(dp[i-1][w], dp[i-1][w - weights[i-1]] + gains[i-1])
#             else:
#                 dp[i][w] = dp[i-1][w]  # Cannot include the item, carry forward the previous value

#     # The answer will be in dp[n][k], i.e., considering all items and capacity k
#     return dp[n][k]


def knapsack_optimized(k, weights, gains):
    n = len(weights)
    dp = [0] * (k + 1)

    for i in range(n):
        for w in range(k, weights[i] - 1, -1):
            dp[w] = max(dp[w], dp[w - weights[i]] + gains[i])

    return dp[k]



def power(n, p):
    if p == 0:
        return 1
    if p < 0:
        return 0

    if (p & 1 == 0):
        term = power(n, (p >> 1)) % MOD
        return (term * term) % MOD
    else:
        return ((n % MOD) * power(n, p - 1)) % MOD


def get_diagonals(matrix):
    rows, cols = len(matrix), len(matrix[0])
    diagonals = []

    # Under and mid
    for j in range(rows):
        diagonal = [matrix[i][i - j] for i in range(j, rows)]
        diagonals.append(diagonal)

    # Above
    for j in range(1, cols):
        diagonal = [matrix[i][i + j] for i in range(rows - j)]
        diagonals.append(diagonal)

    return diagonals

def get_mode(arr):
    arr.sort()
    mode = arr[0]
    h_freq = 1
    cur_freq = 1
    for i in range(1, len(arr)):
        if arr[i] == arr[i - 1]:
            cur_freq += 1
            if cur_freq > h_freq:
                h_freq = cur_freq
                mode = arr[i]
        else:
            cur_freq = 1

    return mode


def read_numbers(infile=None):
    return list(map(int, input().strip().split())) if infile == None else map(int, infile.readline().strip().split())

def read_int(infile=None):
    return int(input().strip()) if infile == None else int(infile.readline().strip())

def read_str(infile=None):
    return input().strip() if infile == None else infile.readline().strip()

def get_median(numbers):
    if not numbers:
        return None  # Handle the empty list case

    numbers = sorted(numbers)  # Sort the list
    n = len(numbers)

    # If the list length is odd, return the middle element
    if n % 2 == 1:
        return numbers[n // 2]
    # If the list length is even, return the average of the two middle elements
    else:
        mid1 = numbers[n // 2 - 1]
        mid2 = numbers[n // 2]
        return (mid1 + mid2) / 2

def comb_optimized(n, r, m):
    if n == r or r == 0: return 1
    return (((factorial(1, n, m) * (mod_inverse_euclidean(factorial(1, r, m), m))) % m) * mod_inverse_euclidean(factorial(1, n - r, m), m)) % m


def solve(file=False, infile=None, outfile=None):
    alpha = "abcdefghijklmnopqrstuvwxyz"
    n = read_int()
    # n = read_int(file=True, infile=infile)
    # n, q = read_numbers()
    # s = input().strip()
    # b = input().strip()
    # t = input().strip()
    # pos = int(input())
    # n = len(s)
    # k = min(k, 12*n)
    # arr = read_numbers()
    # b = list(map(int, input().split()))

    # ------- Graph -------
    # adj = [[] for _ in range(n+1)]
    # for _ in range(n - 1):
        # u, v = list(map(int, input().split()))
        # u, v = arr[i - 2], i
        # adj[u].append(v)
        # adj[v].append(u)


    # Key Observations



    # Actions



    # Thinking

    ranges = []
    scores = []
    for _ in range(n):
        l, r = read_numbers()
        scores.append([l, 1])
        scores.append([r, -1])

    scores.sort(key= lambda p : p[0])
    cur = 0
    ans = 0
    for _, points in scores:
        cur += points
        ans = max(cur, ans)
        # print(points)

    print(ans)

        # ranges.append([l, r])

    # ranges.sort(key=lambda p : p[1])
    # # print(ranges)
    # cur = 1
    # ans = 1
    # ends = [ranges[0][1]]
    # idx = 0
    # for l, r in ranges[1:]:
    #     while idx < len(ends) and ends[idx] < l:

    #         idx += 1
    #         cur -= 1

    #     ends.append(r)  
    #     cur += 1
    #     ans = max(ans, cur)

    # print(ans)







    # outfile.write(str(mn) + "\n")


# -------------- For Interactive Questions ---------------
# def query(i, j):
#     print(f"? {i + 1} {j + 1}")
#     # print()
#     flush()
#     return int(input().strip())


# -------------- For File input output Questions --------------
# with open("maxcross.in", "r") as infile, open("maxcross.out", "w") as outfile:
#     t = 1
#     # t = int(input())
#     for _ in range(t):
#         solve(file=True, infile=infile, outfile=outfile)
#         # threading.Thread(target=solve).start()


t = 1
# t = int(input())
for _ in range(t):
    solve()
    # threading.Thread(target=solve).start()