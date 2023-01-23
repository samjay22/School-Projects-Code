package main

import (
    "container/heap"
    "fmt"
    "math"
)

const ROWS = 5
const COLS = 5

type Node struct {
    x, y int
    dist int
}

type PriorityQueue []*Node

func (pq PriorityQueue) Len() int { return len(pq) }

func (pq PriorityQueue) Less(i, j int) bool {
    return pq[i].dist < pq[j].dist
}

func (pq PriorityQueue) Swap(i, j int) {
    pq[i], pq[j] = pq[j], pq[i]
}

func (pq *PriorityQueue) Push(x interface{}) {
    item := x.(*Node)
    *pq = append(*pq, item)
}

func (pq *PriorityQueue) Pop() interface{} {
    old := *pq
    n := len(old)
    item := old[n-1]
    *pq = old[0 : n-1]
    return item
}

var path []string
var dist [ROWS][COLS]int
var visited [ROWS][COLS]bool

var dx = []int{-1, 0, 1, 0}
var dy = []int{0, 1, 0, -1}

func heuristic(x, y int) int {
    return int(math.Abs(float64(x-ROWS+1)) + math.Abs(float64(y-COLS+1)))
}

func aStar(maze [ROWS][COLS]rune) {
    var pq PriorityQueue

    for i := 0; i < ROWS; i++ {
        for j := 0; j < COLS; j++ {
            dist[i][j] = 1e9
        }
    }

    dist[0][0] = 0
    heap.Push(&pq, &Node{0, 0, 0 + heuristic(0, 0)})

    for pq.Len() > 0 {
        cur := heap.Pop(&pq).(*Node)

        x, y := cur.x, cur.y
        if visited[x][y] {
            continue
        }
        visited[x][y] = true

        path = append(path, fmt.Sprintf("%d:%d", x+1, y+1))

        if x == ROWS-1 && y == COLS-1 {
            return
        }

        for i := 0; i < 4; i++ {
            newX, newY := x+dx[i], y+dy[i]

            if newX >= 0 && newX < ROWS && newY >= 0 && newY < COLS && !visited[newX][newY] && maze[newX][newY] == 'O' {
                if dist[newX][newY] > dist[x][y]+1 {
                    dist[newX][newY] = dist[x][y] + 1
                    heap.Push(&pq, &Node{newX, newY, dist[newX][newY] + heuristic(newX, newY)})
                }
            }
        }
    }
}

func main() {
    maze := [ROWS][COLS]rune{
        {'O', 'X', 'X', 'X', 'X'},
        {'O', 'O', 'O', 'X', 'X'},
        {'O', 'X', 'O', 'X', 'X'},
        {'O', 'X', 'O', 'X', 'X'},
        {'X', 'X', 'O', 'O', 'O'},
    }
    aStar(maze)
    fmt.Println(path)
}
