package main

import (
	"./inputs"
	"fmt"
	"regexp"
)

func main() {
	summary := 0
	for _, pattern := range inputs.Day13 {
		lines := regexp.MustCompile("\r?\n").Split(pattern, -1)
		summary += summarizeReflection(lines)
	}

	fmt.Println(summary)
}

func summarizeReflection(lines []string) int {
	// Check for horizontal reflection
Horizontal:
	for i := 1; i < len(lines); i++ {
		offset := 0
		for {
			for j := range lines[i] {
				if lines[i+offset][j] != lines[i-offset-1][j] {
					continue Horizontal
				}
			}

			offset++
			if i-offset-1 < 0 || i+offset >= len(lines) {
				return i * 100
			}
		}
	}

	// Check for vertical reflection
Vertical:
	for j := 1; j < len(lines[0]); j++ {
		offset := 0
		for {
			for i := range lines {
				if lines[i][j+offset] != lines[i][j-offset-1] {
					continue Vertical
				}
			}

			offset++
			if j-offset-1 < 0 || j+offset >= len(lines[0]) {
				return j
			}
		}
	}

	fmt.Println("No reflection found!")
	return -1
}
