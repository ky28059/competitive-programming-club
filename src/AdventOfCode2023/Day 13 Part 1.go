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
Horizontal:
	// Check for horizontal reflection
	for i := 1; i < len(lines); i++ {
		for offset := 0; ; offset++ {
			for j := range lines[i] {
				if lines[i+offset][j] != lines[i-offset-1][j] {
					continue Horizontal
				}
			}

			if i-offset-2 < 0 || i+offset == len(lines)-1 {
				return i * 100
			}
		}
	}

Vertical:
	// Check for vertical reflection
	for j := 1; j < len(lines[0]); j++ {
		for offset := 0; ; offset++ {
			for i := range lines {
				if lines[i][j+offset] != lines[i][j-offset-1] {
					continue Vertical
				}
			}

			if j-offset-2 < 0 || j+offset == len(lines[0])-1 {
				return j
			}
		}
	}

	fmt.Println("No reflection found!")
	return -1
}
