package main

import (
	"./inputs"
	"fmt"
	"strconv"
	"strings"
)

func main() {
	sum := 0
	for _, line := range inputs.Day2 {
		_, after, _ := strings.Cut(line, ": ")
		subsets := strings.Split(after, "; ")

		rMax, gMax, bMax := 0, 0, 0
		for _, subset := range subsets {
			cubes := strings.Split(subset, ", ")

			for _, cube := range cubes {
				c, color, _ := strings.Cut(cube, " ")
				count, _ := strconv.Atoi(c)

				switch strings.TrimSpace(color) {
				case "red":
					rMax = max(rMax, count)
				case "green":
					gMax = max(gMax, count)
				case "blue":
					bMax = max(bMax, count)
				}
			}
		}

		sum += rMax * gMax * bMax
	}

	fmt.Println(sum)
}
