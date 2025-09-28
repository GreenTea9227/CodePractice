def solution(weights):
    answer = 0
    count = [0] * 1_001
    
    for w in weights:
        count[w] += 1
    
    for weight in range(1_001):
        if count[weight] >= 2:
            answer += count[weight] * (count[weight] - 1) // 2
    
    for i in range(1_001):
        if count[i] == 0:
            continue
        for j in range(i + 1, 1_001):
            if count[j] == 0:
                continue
            if can_balance(i, j):
                answer += count[i] * count[j]
    
    return answer

def can_balance(a, b):
    return any([a * dist1 == b * dist2 for dist1 in [2,3,4] for dist2 in [2,3,4]])