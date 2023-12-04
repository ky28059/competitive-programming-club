package main

import (
	"./inputs"
	"fmt"
	"regexp"
	"strings"
)

func main() {
	sum := 0
	for _, line := range inputs.Day4 {
		split := strings.Split(line[9:], " | ")
		winning := regexp.MustCompile("\\s+").Split(strings.TrimSpace(split[0]), -1)
		yours := regexp.MustCompile("\\s+").Split(strings.TrimSpace(split[1]), -1)

		winCount := 0
		for _, num := range winning {
			for _, num2 := range yours {
				if num == num2 {
					winCount++
					break
				}
			}
		}

		if winCount > 0 {
			sum += Pow(2, winCount-1)
		}
	}
	fmt.Println(sum)
}

// Pow https://stackoverflow.com/questions/64108933/how-to-use-math-pow-with-integers-in-golang
func Pow(n, m int) int {
	if m == 0 {
		return 1
	}
	result := n
	for i := 2; i <= m; i++ {
		result *= n
	}
	return result
}
