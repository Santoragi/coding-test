from collections import deque

def solution(maps):
    n = len(maps)
    m = len(maps[0])

    visited = [[False] * m for _ in range(n)]
    q = deque()

    # y, x, dist
    q.append((0, 0, 1))
    visited[0][0] = True

    dy = [1, -1, 0, 0]
    dx = [0, 0, 1, -1]
    
    while q:
        y, x, dist = q.popleft()

        if y == n - 1 and x == m - 1:
            return dist

        for i in range(4):
            ny = y + dy[i]
            nx = x + dx[i]

            if ny >= len(maps) or ny < 0 or nx >= len(maps[0]) or nx < 0:
                continue
            if maps[ny][nx] == 0:
                continue
            if visited[ny][nx]:
                continue
            
            visited[ny][nx] = True
            q.append((ny, nx, dist + 1))

    return -1