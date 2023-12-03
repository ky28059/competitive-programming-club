package main

import (
	"./inputs"
	"fmt"
	"strconv"
	"unicode"
)

func main() {
	gears := make(map[string][]int)

	for i, line := range inputs.Day3 {
		for j := 0; j < len(line); j++ {
			if !unicode.IsNumber(rune(line[j])) {
				continue
			}

			// Slice until there are no more digits
			start, end := j, j
			for k := start + 1; k < len(line) && unicode.IsNumber(rune(line[k])); k++ {
				end++
				j++
			}
			num, _ := strconv.Atoi(line[start : end+1])

			// Check adjacent cells for gears
			gi, gj, adjacent := isAdjacentToGear(i, start, end)
			if adjacent {
				l := gears[string(rune(gi))+string(rune(gj))]
				gears[string(rune(gi))+string(rune(gj))] = append(l, num)
			}
		}
	}

	// Sum gear ratios of gears adjacent to 2 numbers
	sum := 0
	for _, nums := range gears {
		if len(nums) == 2 {
			sum += nums[0] * nums[1]
		}
	}
	fmt.Println(sum)
}

func isAdjacentToGear(i, start, end int) (int, int, bool) {
	rowStart := i - 1
	if i == 0 {
		rowStart = i
	}
	rowEnd := i + 1
	if i == len(inputs.Day3)-1 {
		rowEnd = i
	}
	colStart := start - 1
	if start == 0 {
		colStart = start
	}
	colEnd := end + 1
	if end == len(inputs.Day3[0])-1 {
		colEnd = end
	}

	for i := rowStart; i <= rowEnd; i++ {
		for j := colStart; j <= colEnd; j++ {
			if inputs.Day3[i][j] == '*' {
				return i, j, true
			}
		}
	}

	return 0, 0, false
}
