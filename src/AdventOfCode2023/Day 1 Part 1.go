package main

import (
	"./inputs"
	"fmt"
	"regexp"
	"strconv"
)

func main() {
	r, _ := regexp.Compile("^.*?(\\d)(?:.*(\\d))?.*?$")

	sum := 0
	for _, line := range inputs.Day1 {
		matches := r.FindSubmatch([]byte(line))

		// https://stackoverflow.com/questions/19832189/unpack-slices-on-assignment
		// https://stackoverflow.com/questions/19979178/what-is-the-idiomatic-go-equivalent-of-cs-ternary-operator
		first := string(matches[1])
		second := string(matches[2])
		if second == "" {
			second = first
		}

		s, _ := strconv.Atoi(first + second)
		sum += s
	}
	fmt.Println(sum)
}
