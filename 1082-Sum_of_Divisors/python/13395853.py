import sys
import math

def sum_divisors(n: int) -> int:
    sqrt = int(math.sqrt(n))
    mod = (10 ** 9) + 7

    a_div_count = [1 for _ in range(sqrt + 1)]

    def sum_to_incl(x: int):
        return ((x) * (x + 1)) // 2

    def sum_ints_incl(start: int, end: int) -> int:
        s_e = sum_to_incl(end)
        s_s = sum_to_incl(start - 1)
        return s_e - s_s

    for div in range(1, sqrt + 1):
        a_div_count[div] = n // div

    # first pass, get unique divisors < (sqrt n) and add
    s = 0 
    # print('first pass')
    for div in range(1, sqrt + 1):
        s += div * a_div_count[div]
        s %= mod
        # print('count div', a_div_count[div], div)


    # print('second pass')
    # second pass, get numbers after unique divisors (repeated ones) that have common count values (< sqrt of n)
    a_count_to_max = a_div_count
    for count in range(1, sqrt + 1):
        a_min = sqrt + 1
        if count < sqrt:
            # we have a min below
            a_min = a_count_to_max[count + 1] + 1

        a_max = a_count_to_max[count]

        # print('count min max', count, a_min, a_max)
        s_min_max = sum_ints_incl(a_min, a_max)
        # print('s_min_max', s_min_max)
        s += s_min_max * count
        s %= mod

    return s


if __name__ == "__main__": 
    stdin = sys.stdin
    stdout = sys.stdout

    n = int(stdin.readline().strip())

    res = sum_divisors(n)

    stdout.write(str(res) + '\n')
    stdout.flush()