package main

import (
	"./inputs"
	. "./util"
	"fmt"
	"regexp"
)

func main() {
	nodes := make(map[string]Node)

	lineRegex := regexp.MustCompile("(\\w+) = \\((\\w+), (\\w+)\\)")
	lines := regexp.MustCompile("\r\n?").Split(inputs.Day8[1], -1)
	for _, line := range lines {
		matches := lineRegex.FindSubmatch([]byte(line))
		nodes[string(matches[1])] = Node{
			Left:  string(matches[2]),
			Right: string(matches[3]),
		}
	}

	current := nodes["AAA"]
	for i := 0; ; i++ {
		instr := inputs.Day8[0][i%len(inputs.Day8[0])]

		nextStr := current.Left
		if string(instr) == "R" {
			nextStr = current.Right
		}

		fmt.Println(string(instr), nextStr)

		if nextStr == "ZZZ" {
			fmt.Println(i + 1)
			break
		}

		current = nodes[nextStr]
	}
}
