package main

import (
	"./inputs"
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

				fmt.Println(len(points))

				// Write main path to file for debugging
				// util.WriteMapFile(m, "day10.out")

				// Append first two points for cyclicity
				points = append(points, points[0:1]...)

				area := 0
				for i := 2; i < len(points); i++ {
					p1, p2, p3 := points[i-2], points[i-1], points[i]

					delta := 0
					if p2.J > p1.J {
						delta = p2.I + 1
					} else if p2.J < p1.J {
						delta = -p2.I
					}

					// If going vertically afterward, double the delta to account for points
					// being in the center of the polygon.
					if p3.I != p2.I {
						area += delta
					}
					area += delta
				}
				fmt.Println(area)
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
