package main

import (
	"./inputs"
	. "./util"
	"fmt"
)

func main() {
	var galaxies []Point
	var emptyRows []int
	var emptyCols []int

	for i, line := range inputs.Day11 {
		empty := true
		for j, c := range line {
			// Mark all galaxies
			if c == '#' {
				galaxies = append(galaxies, Point{I: i, J: j})
				empty = false
			}
		}

		// If empty, add to cosmic expansion list
		if empty {
			emptyRows = append(emptyRows, i)
		}
	}

	// Apply cosmic expansion to columns
	for j := range inputs.Day11[0] {
		empty := true
		for _, c := range galaxies {
			if c.J == j {
				empty = false
				break
			}
		}

		if empty {
			emptyCols = append(emptyCols, j)
		}
	}

	sum := 0
	for i, g := range galaxies {
		for j := i; j < len(galaxies); j++ {
			g2 := galaxies[j]

			jMin := min(g.J, g2.J)
			jMax := max(g.J, g2.J)
			iMin := min(g.I, g2.I)
			iMax := max(g.I, g2.I)

			// Shortest distance is equivalent to manhattan distance
			dist := (iMax - iMin) + (jMax - jMin)

			// If path goes through empty rows / columns, add one to account for cosmic expansion
			for _, r := range emptyRows {
				if iMin < r && r < iMax {
					dist++
				}
			}
			for _, c := range emptyCols {
				if jMin < c && c < jMax {
					dist++
				}
			}

			sum += dist
		}
	}

	fmt.Println(sum)
}
