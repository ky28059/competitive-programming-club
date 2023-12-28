package main

import (
	"./inputs"
	"./util"
	. "./util"
	"fmt"
)

func main() {
	for i, l := range inputs.Day10 {
		for j, c := range l {
			if c == 'S' {
				points := getMainLoopPoints(make([]Point, 0), i+1, j, i, j)
				if len(points) == 0 {
					points = getMainLoopPoints(make([]Point, 0), i-1, j, i, j)
				}
				if len(points) == 0 {
					points = getMainLoopPoints(make([]Point, 0), i, j+1, i, j)
				}
				if len(points) == 0 {
					points = getMainLoopPoints(make([]Point, 0), i, j-1, i, j)
				}

				// Write main path to file for debugging
				// util.WriteMapFile(m, "day10.out")

				area := util.Shoelace(points)
				fmt.Println("Polygon area:", area, "| Pipe length:", len(points))
				fmt.Println(area - len(points))
				return
			}
		}
	}
}

func getMainLoopPoints(points []Point, i, j, pi, pj int) []Point {
	if inputs.Day10[i][j] == 'S' {
		return append(points, Point{I: i, J: j})
	}

	switch inputs.Day10[i][j] {
	case '|':
		switch {
		case j != pj:
			return make([]Point, 0)
		case i > pi:
			return getMainLoopPoints(append(points, Point{I: i, J: j}), i+1, j, i, j)
		default:
			return getMainLoopPoints(append(points, Point{I: i, J: j}), i-1, j, i, j)
		}
	case '-':
		switch {
		case i != pi:
			return make([]Point, 0)
		case j > pj:
			return getMainLoopPoints(append(points, Point{I: i, J: j}), i, j+1, i, j)
		default:
			return getMainLoopPoints(append(points, Point{I: i, J: j}), i, j-1, i, j)
		}
	case 'L': // (0, 0) -> (0, 1) <- (1, 1)
		switch {
		case i != pi+1 && j != pj-1:
			return make([]Point, 0)
		case i == pi+1:
			return getMainLoopPoints(append(points, Point{I: i, J: j}), i, j+1, i, j)
		default:
			return getMainLoopPoints(append(points, Point{I: i, J: j}), i-1, j, i, j)
		}
	case 'J': // (1, 0) -> (1, 1) <- (0, 1)
		switch {
		case i != pi+1 && j != pj+1:
			return make([]Point, 0)
		case i == pi+1:
			return getMainLoopPoints(append(points, Point{I: i, J: j}), i, j-1, i, j)
		default:
			return getMainLoopPoints(append(points, Point{I: i, J: j}), i-1, j, i, j)
		}
	case 'F': // (1, 0) -> (0, 0) <- (0, 1)
		switch {
		case i != pi-1 && j != pj-1:
			return make([]Point, 0)
		case i == pi-1:
			return getMainLoopPoints(append(points, Point{I: i, J: j}), i, j+1, i, j)
		default:
			return getMainLoopPoints(append(points, Point{I: i, J: j}), i+1, j, i, j)
		}
	case '7': // (0, 0) -> (1, 0) <- (1, 1)
		switch {
		case i != pi-1 && j != pj+1:
			return make([]Point, 0)
		case i == pi-1:
			return getMainLoopPoints(append(points, Point{I: i, J: j}), i, j-1, i, j)
		default:
			return getMainLoopPoints(append(points, Point{I: i, J: j}), i+1, j, i, j)
		}
	default:
		return make([]Point, 0)
	}
}
