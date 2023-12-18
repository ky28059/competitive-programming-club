package main

import (
	"./inputs"
	"fmt"
	"regexp"
)

type node struct {
	left  string
	right string
}

func main() {
	nodes := make(map[string]node)

	lineRegex := regexp.MustCompile("(\\w+) = \\((\\w+), (\\w+)\\)")
	lines := regexp.MustCompile("\r\n?").Split(inputs.Day8[1], -1)
	for _, line := range lines {
		matches := lineRegex.FindSubmatch([]byte(line))
		nodes[string(matches[1])] = node{
			left:  string(matches[2]),
			right: string(matches[3]),
		}
	}

	current := nodes["AAA"]
	for i := 0; ; i++ {
		instr := inputs.Day8[0][i%len(inputs.Day8[0])]

		nextStr := current.left
		if string(instr) == "R" {
			nextStr = current.right
		}

		fmt.Println(string(instr), nextStr)

		if nextStr == "ZZZ" {
			fmt.Println(i + 1)
			break
		}

		current = nodes[nextStr]
	}
}
