def count_distinct_numbers():
    import sys
    input = sys.stdin.read
    data = input().split()
    n = int(data[0])  
    numbers = data[1:] 


    distinct_count = len(set(numbers))

    print(distinct_count)


count_distinct_numbers()