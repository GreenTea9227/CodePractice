def solution(numbers):
    answer = []
    for number in numbers:
        binary_num = bin(number)[2:]
        
        length = len(binary_num)
        target_length = 1
        while target_length < length:
            target_length = target_length * 2 + 1
        
        padded_binary = binary_num.zfill(target_length)
        
        if check(padded_binary):
            answer.append(1)
        else:
            answer.append(0)
        
    return answer

def check(binary_str):
    def is_valid(start, end):
        if start > end:
            return True
        
        mid = (start + end) // 2
        left_child = (start + mid - 1) // 2
        right_child = (mid + 1 + end) // 2
        
        # 현재 노드가 0인데 자식이 1인 경우 -> 불가능
        if binary_str[mid] == '0':
            if start <= end and start != end:  # 자식이 존재하는 경우
                if (start <= left_child and binary_str[left_child] == '1') or (right_child <= end and binary_str[right_child] == '1'):
                    return False
        
        # 재귀적으로 왼쪽, 오른쪽 서브트리 검사
        return is_valid(start, mid - 1) and is_valid(mid + 1, end)
    
    return is_valid(0, len(binary_str) - 1)