package inputs

import (
	"os"
	"regexp"
)

const BasePath = "src/AdventOfCode2023"

func getInput(p string) string {
	dat, _ := os.ReadFile(BasePath + "/" + p)
	return string(dat)
}

var Day1 = regexp.MustCompile("\r?\n").Split(getInput("day1.in"), -1)
var Day2 = regexp.MustCompile("\r?\n").Split(getInput("day2.in"), -1)
var Day3 = regexp.MustCompile("\r?\n").Split(getInput("day3.in"), -1)
var Day4 = regexp.MustCompile("\r?\n").Split(getInput("day4.in"), -1)
var Day5 = regexp.MustCompile("\r?\n\r?\n\\w+-to-\\w+ map:\r?\n").Split(getInput("day5.in"), -1)
var Day6 = regexp.MustCompile("\r?\n").Split(getInput("day6.in"), -1)

var Day8 = regexp.MustCompile("\r?\n\r?\n").Split(getInput("day8.in"), -1)

var Day10 = regexp.MustCompile("\r?\n").Split(getInput("day10.in"), -1)
var Day11 = regexp.MustCompile("\r?\n").Split(getInput("day11.in"), -1)
