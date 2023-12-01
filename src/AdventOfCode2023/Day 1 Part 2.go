package main

import (
	"fmt"
	"regexp"
	"strconv"
)
import "./inputs"

func main() {
	r, _ := regexp.Compile("^.*?(\\d|one|two|three|four|five|six|seven|eight|nine)(?:.*(\\d|one|two|three|four|five|six|seven|eight|nine))?.*?$")

	sum := 0
	for _, line := range inputs.Day1 {
		matches := r.FindSubmatch([]byte(line))

		first := parseDigit(string(matches[1]))
		second := parseDigit(string(matches[2]))
		if second == "" {
			second = first
		}

		s, _ := strconv.Atoi(first + second)
		sum += s
	}
	fmt.Println(sum)
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
