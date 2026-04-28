from collections import deque

def solution(numbers, target):
    q = deque()
    q.append((0, 0))
    
    answer = 0
    while q:
        idx, total = q.popleft()

        if idx == len(numbers):
            if total == target:
                answer += 1
            continue
        
        q.append((idx + 1, total + numbers[idx]))
        q.append((idx + 1, total - numbers[idx]))

    return answer