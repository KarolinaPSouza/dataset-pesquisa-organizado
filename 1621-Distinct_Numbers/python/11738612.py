n = input()
numbers = list(map(int, input().split()))

if numbers.count(numbers[0]) == len(numbers):
    # caso de todos os números forem iguais
    print(1)
else:
    # ordenar para contar os distintos
    numbers.sort()
    count_distincts = 0

    index = 0
    for i in numbers:
        # se o número atual for diferente do anterior
        if i != numbers[index - 1]:
            count_distincts += 1

        index += 1

    print(count_distincts)