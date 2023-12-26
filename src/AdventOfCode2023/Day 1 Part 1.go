package main

import (
	"./inputs"
	"./util"
	"fmt"
	"regexp"
	"strconv"
)

func main() {
	fmt.Println(util.SumOf(inputs.Day1, func(line string) int {
		matches := regexp.MustCompile("^.*?(\\d)(?:.*(\\d))?.*?$").FindStringSubmatch(line)

		// https://stackoverflow.com/questions/19832189/unpack-slices-on-assignment
		// https://stackoverflow.com/questions/19979178/what-is-the-idiomatic-go-equivalent-of-cs-ternary-operator
		first := matches[1]
		second := matches[2]
		if second == "" {
			second = first
		}

		s, _ := strconv.Atoi(first + second)
		return s
	}))
}
