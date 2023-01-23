package main

import "fmt"

const ROWS = 5
const COLS = 5

var path []string
var visited [ROWS][COLS]bool

func findPath(maze [ROWS][COLS]rune, x int, y int) bool {
    if x == ROWS-1 && y == COLS-1 {
        path = append(path, fmt.Sprintf("%d:%d", x+1, y+1))
        return true
    }

    if x >= 0 && x < ROWS && y >= 0 && y < COLS && !visited[x][y] && maze[x][y] == 'O' {
        visited[x][y] = true
        path = append(path, fmt.Sprintf("%d:%d", x+1, y+1))

        if findPath(maze, x, y+1) {
            return true
        }

        if findPath(maze, x+1, y) {
            return true
        }

        path = path[:len(path)-1]
        visited[x][y] = false
    }

    return false
}

func main() {
    maze := [ROWS][COLS]rune{
        {'O', 'X', 'X', 'X', 'X'},
        {'O', 'O', 'O', 'X', 'X'},
        {'O', 'X', 'O', 'X', 'X'},
        {'O', 'X', 'O', 'X', 'X'},
        {'X', 'X', 'O', 'O', 'O'},
    }

    findPath(maze, 0, 0)
    fmt.Println(path)
}
