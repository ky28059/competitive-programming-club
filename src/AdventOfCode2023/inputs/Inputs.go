package inputs

import (
	"os"
	"strings"
)

const BASE_PATH = "src/AdventOfCode2023"

func getInput(p string) string {
	dat, _ := os.ReadFile(BASE_PATH + "/" + p)
	return string(dat)
}

var Day1 = strings.Split(getInput("day1.in"), "\n")
