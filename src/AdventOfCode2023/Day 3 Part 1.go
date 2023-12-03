package main

import (
	"./inputs"
	"fmt"
	"strconv"
	"unicode"
)

func main() {
	sum := 0
	for i, line := range inputs.Day3 {
		for j := 0; j < len(line); j++ {
			if !unicode.IsNumber(rune(line[j])) {
				continue
			}

			// Slice until there are no more digits
			// start = index of first character in num; end = index of last character in num
			start, end := j, j
			for k := start + 1; k < len(line) && unicode.IsNumber(rune(line[k])); k++ {
				end++
				j++
			}
			num, _ := strconv.Atoi(line[start : end+1])

			// Check all adjacent cells for symbols
			if isAdjacentToSymbol(i, start, end) {
				sum += num
			}
		}
	}
	fmt.Println(sum)
}

func isAdjacentToSymbol(i, start, end int) bool {
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
			if isSymbol(rune(inputs.Day3[i][j])) {
				return true
			}
		}
	}

	return false
}

func isSymbol(r rune) bool {
	return r != '.' && !unicode.IsNumber(r)
}
