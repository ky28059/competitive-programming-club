package main

import (
	"./inputs"
	"./util"
	"fmt"
)

func main() {
	states := make([][][]bool, 65)
	for i := range states {
		visited := make([][]bool, len(inputs.Day21))
		for j := range visited {
			visited[j] = make([]bool, len(inputs.Day21[0]))
		}
		states[i] = visited
	}

	for i, line := range inputs.Day21 {
		for j, c := range line {
			if c == 'S' {
				floodFillSteps(64, states, i, j)

				fmt.Println(util.CountTrue(states[0]))
				util.WriteMapFile(states[0], "day21.out")
				return
			}
		}
	}
}

func floodFillSteps(remaining int, states [][][]bool, i, j int) {
	if inputs.Day21[i][j] == '#' || states[remaining][i][j] {
		return
	}

	states[remaining][i][j] = true

	if remaining == 0 {
		return
	}

	floodFillSteps(remaining-1, states, i+1, j)
	floodFillSteps(remaining-1, states, i-1, j)
	floodFillSteps(remaining-1, states, i, j+1)
	floodFillSteps(remaining-1, states, i, j-1)
}
