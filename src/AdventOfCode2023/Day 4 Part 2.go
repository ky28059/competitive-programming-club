package main

import (
	"./inputs"
	"fmt"
	"regexp"
	"strings"
)

func main() {
	instances := make([]int, len(inputs.Day4))

	sum := 0
	for i, line := range inputs.Day4 {
		count := instances[i] + 1

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

		// Win a copy of the next x scratchers
		for j := 1; j <= winCount; j++ {
			instances[i+j] += count
		}

		sum += count
	}
	fmt.Println(sum)
}
