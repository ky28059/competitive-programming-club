package main

import (
	"./inputs"
	"./util"
	. "./util"
	"fmt"
)

func main() {
	// https://stackoverflow.com/questions/39804861/what-is-a-concise-way-to-create-a-2d-slice-in-go
	m := make([][]bool, len(inputs.Day10))
	for i := range m {
		m[i] = make([]bool, len(inputs.Day10[0]))
	}

Outer:
	for i, l := range inputs.Day10 {
		for j, c := range l {
			if c == 'S' {
				paintMainLoopPoints(m, make([]Point, 0), i+1, j, i, j)
				paintMainLoopPoints(m, make([]Point, 0), i-1, j, i, j)
				paintMainLoopPoints(m, make([]Point, 0), i, j+1, i, j)
				paintMainLoopPoints(m, make([]Point, 0), i, j-1, i, j)

				// Write main path to file for debugging
				util.WriteMapFile(m, "day10.out")

				break Outer
			}
		}
	}

	// TODO: account for "squeezing between pipes"
	sum := 0
	for i, l := range m {
		inside := false
		temp := 0

		for j := range l {
			switch {
			case m[i][j] && !inside: // rising edge
				inside = true
			case m[i][j] && inside: // falling edge
				inside = false
				sum += temp
				temp = 0
			case inside:
				temp++
			}
		}
	}
	fmt.Println(sum)
}

func paintMainLoopPoints(m [][]bool, points []Point, i, j, pi, pj int) {
	if inputs.Day10[i][j] == 'S' {
		// Paint all points now that the loop is completed
		for _, p := range points {
			m[p.I][p.J] = true
		}
		m[i][j] = true
		return
	}

	switch inputs.Day10[i][j] {
	case '|':
		switch {
		case j != pj:
			return
		case i > pi:
			paintMainLoopPoints(m, append(points, Point{I: i, J: j}), i+1, j, i, j)
		default:
			paintMainLoopPoints(m, append(points, Point{I: i, J: j}), i-1, j, i, j)
		}
	case '-':
		switch {
		case i != pi:
			return
		case j > pj:
			paintMainLoopPoints(m, append(points, Point{I: i, J: j}), i, j+1, i, j)
		default:
			paintMainLoopPoints(m, append(points, Point{I: i, J: j}), i, j-1, i, j)
		}
	case 'L': // (0, 0) -> (0, 1) <- (1, 1)
		switch {
		case i != pi+1 && j != pj-1:
			return
		case i == pi+1:
			paintMainLoopPoints(m, append(points, Point{I: i, J: j}), i, j+1, i, j)
		default:
			paintMainLoopPoints(m, append(points, Point{I: i, J: j}), i-1, j, i, j)
		}
	case 'J': // (1, 0) -> (1, 1) <- (0, 1)
		switch {
		case i != pi+1 && j != pj+1:
			return
		case i == pi+1:
			paintMainLoopPoints(m, append(points, Point{I: i, J: j}), i, j-1, i, j)
		default:
			paintMainLoopPoints(m, append(points, Point{I: i, J: j}), i-1, j, i, j)
		}
	case 'F': // (1, 0) -> (0, 0) <- (0, 1)
		switch {
		case i != pi-1 && j != pj-1:
			return
		case i == pi-1:
			paintMainLoopPoints(m, append(points, Point{I: i, J: j}), i, j+1, i, j)
		default:
			paintMainLoopPoints(m, append(points, Point{I: i, J: j}), i+1, j, i, j)
		}
	case '7': // (0, 0) -> (1, 0) <- (1, 1)
		switch {
		case i != pi-1 && j != pj+1:
			return
		case i == pi-1:
			paintMainLoopPoints(m, append(points, Point{I: i, J: j}), i, j-1, i, j)
		default:
			paintMainLoopPoints(m, append(points, Point{I: i, J: j}), i+1, j, i, j)
		}
	default:
		return
	}
}
