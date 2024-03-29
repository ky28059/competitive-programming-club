package inputs

import (
	"os"
	"regexp"
	"strings"
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
var Day9 = regexp.MustCompile("\r?\n").Split(getInput("day9.in"), -1)
var Day10 = regexp.MustCompile("\r?\n").Split(getInput("day10.in"), -1)
var Day11 = regexp.MustCompile("\r?\n").Split(getInput("day11.in"), -1)

var Day13 = regexp.MustCompile("\r?\n\r?\n").Split(getInput("day13.in"), -1)
var Day14 = regexp.MustCompile("\r?\n").Split(getInput("day14.in"), -1)
var Day15 = strings.Split(getInput("day15.in"), ",")
var Day16 = regexp.MustCompile("\r?\n").Split(getInput("day16.in"), -1)

var Day18 = regexp.MustCompile("\r?\n").Split(getInput("day18.in"), -1)
var Day19 = regexp.MustCompile("\r?\n\r?\n").Split(getInput("day19.in"), -1)

var Day21 = regexp.MustCompile("\r?\n").Split(getInput("day21.in"), -1)
