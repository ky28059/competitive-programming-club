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
		before, after, _ := strings.Cut(line, ": ")

		id, _ := strconv.Atoi(before[5:])
		subsets := strings.Split(after, "; ")

		valid := true
		for _, subset := range subsets {
			cubes := strings.Split(subset, ", ")

			for _, cube := range cubes {
				valid = valid && isValidCubeAmount(cube)
			}
		}

		if valid {
			sum += id
		}
	}

	fmt.Println(sum)
}

func isValidCubeAmount(cube string) bool {
	c, color, _ := strings.Cut(cube, " ")
	count, _ := strconv.Atoi(c)

	switch color {
	case "red":
		if count > 12 {
			return false
		}
	case "green":
		if count > 13 {
			return false
		}
	case "blue":
		if count > 14 {
			return false
		}
	}

	return true
}
