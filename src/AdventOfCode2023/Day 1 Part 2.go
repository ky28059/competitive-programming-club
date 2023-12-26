package main

import (
	"./inputs"
	"./util"
	"fmt"
	"regexp"
	"strconv"
)

func main() {
	r, _ := regexp.Compile("^.*?(\\d|one|two|three|four|five|six|seven|eight|nine)(?:.*(\\d|one|two|three|four|five|six|seven|eight|nine))?.*?$")

	fmt.Println(util.SumOf(inputs.Day1, func(line string) int {
		matches := r.FindStringSubmatch(line)

		first := parseDigit(matches[1])
		second := parseDigit(matches[2])
		if second == "" {
			second = first
		}

		s, _ := strconv.Atoi(first + second)
		return s
	}))
}

func parseDigit(d string) string {
	switch d {
	case "one":
		return "1"
	case "two":
		return "2"
	case "three":
		return "3"
	case "four":
		return "4"
	case "five":
		return "5"
	case "six":
		return "6"
	case "seven":
		return "7"
	case "eight":
		return "8"
	case "nine":
		return "9"
	default:
		return d
	}
}
