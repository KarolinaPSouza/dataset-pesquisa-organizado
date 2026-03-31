import collections


def read_datas():
    n = int(input())
    times = [tuple(map(int, input().split())) for _ in range(n)]
    return n, times


def solve(n, times):
    start_times, end_times = map(list, zip(*times))
    pass  # start_times: list[int]
    pass  # end_times: list[int]
    start_times.sort()
    end_times.sort()

    leave_before_list = []
    end_time_pos = 0
    for index, start in enumerate(start_times):
        while end_times[end_time_pos] < start:
            end_time_pos += 1
        leave_before_list.append(end_time_pos)

    max_amount = max(index + 1 - leave_before_list[index] for index in range(n))
    return max_amount


def main():

    n, times = read_datas()

    max_customers = solve(n, times)
    print(max_customers)


main()