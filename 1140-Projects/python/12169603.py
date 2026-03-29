def binary_search(projects, start, end_days):
    low, high = 0, len(end_days) - 1
    while low <= high:
        mid = (low + high) // 2
        if end_days[mid] < start:
            low = mid + 1
        else:
            high = mid - 1
    return high

def max_money(projects):
    # Ordenar os projetos pelo dia de término
    projects.sort(key=lambda x: x[1])

    # Array para armazenar a quantidade máxima de dinheiro até cada projeto
    dp = [0] * len(projects)
    end_days = [project[1] for project in projects]

    for i in range(len(projects)):
        start, end, reward = projects[i]

        # Encontrar o último projeto que não se sobrepõe ao projeto atual usando busca binária
        j = binary_search(projects, start, end_days)

        # Calcular a quantidade máxima de dinheiro até o projeto atual
        if j != -1:
            dp[i] = max(dp[i - 1], dp[j] + reward)
        else:
            dp[i] = max(dp[i - 1], reward)

    return dp[-1]

# Leitura do número de projetos
n = int(input().strip())

# Leitura dos projetos
projects = []
for _ in range(n):
    a, b, p = map(int, input().strip().split())
    projects.append((a, b, p))

# Calcular a quantidade máxima de dinheiro que pode ser ganha
result = max_money(projects)

# Imprimir o resultado
print(result)