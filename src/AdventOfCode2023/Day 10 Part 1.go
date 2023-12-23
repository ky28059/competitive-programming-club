package main

import (
	"./inputs"
	"fmt"
	"math"
)

func main() {
Outer:
	for i, l := range inputs.Day10 {
		for j, c := range l {
			if c == 'S' {
				down := followPipe(0, i+1, j, i, j)
				up := followPipe(0, i-1, j, i, j)
				right := followPipe(0, i, j+1, i, j)
				left := followPipe(0, i, j-1, i, j)

				fmt.Println("D:", down)
				fmt.Println("U:", up)
				fmt.Println("R:", right)
				fmt.Println("L:", left)

				fmt.Println(int(math.Ceil(float64(max(down, up, right, left)) / 2)))

				break Outer
			}
		}
	}
}

func followPipe(sum, i, j, pi, pj int) int {
	if inputs.Day10[i][j] == 'S' {
		return sum
	}

	switch inputs.Day10[i][j] {
	case '|':
		switch {
		case j != pj:
			return -1
		case i > pi:
			return followPipe(sum+1, i+1, j, i, j)
		default:
			return followPipe(sum+1, i-1, j, i, j)
		}
	case '-':
		switch {
		case i != pi:
			return -1
		case j > pj:
			return followPipe(sum+1, i, j+1, i, j)
		default:
			return followPipe(sum+1, i, j-1, i, j)
		}
	case 'L': // (0, 0) -> (0, 1) <- (1, 1)
		switch {
		case i != pi+1 && j != pj-1:
			return -1
		case i == pi+1:
			return followPipe(sum+1, i, j+1, i, j)
		default:
			return followPipe(sum+1, i-1, j, i, j)
		}
	case 'J': // (1, 0) -> (1, 1) <- (0, 1)
		switch {
		case i != pi+1 && j != pj+1:
			return -1
		case i == pi+1:
			return followPipe(sum+1, i, j-1, i, j)
		default:
			return followPipe(sum+1, i-1, j, i, j)
		}
	case 'F': // (1, 0) -> (0, 0) <- (0, 1)
		switch {
		case i != pi-1 && j != pj-1:
			return -1
		case i == pi-1:
			return followPipe(sum+1, i, j+1, i, j)
		default:
			return followPipe(sum+1, i+1, j, i, j)
		}
	case '7': // (0, 0) -> (1, 0) <- (1, 1)
		switch {
		case i != pi-1 && j != pj+1:
			return -1
		case i == pi-1:
			return followPipe(sum+1, i, j-1, i, j)
		default:
			return followPipe(sum+1, i+1, j, i, j)
		}
	default:
		return -1
	}
}
