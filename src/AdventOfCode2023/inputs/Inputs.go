package inputs

import (
	"os"
	"strings"
)

const BasePath = "src/AdventOfCode2023"

func getInput(p string) string {
	dat, _ := os.ReadFile(BasePath + "/" + p)
	return string(dat)
}

var Day1 = strings.Split(getInput("day1.in"), "\n")
var Day2 = strings.Split(getInput("day2.in"), "\n")
