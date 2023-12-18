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
	var currentNodes []node

	lineRegex := regexp.MustCompile("(\\w+) = \\((\\w+), (\\w+)\\)")
	lines := regexp.MustCompile("\r\n?").Split(inputs.Day8[1], -1)
	for _, line := range lines {
		matches := lineRegex.FindSubmatch([]byte(line))

		nodeName := string(matches[1])
		newNode := node{
			left:  string(matches[2]),
			right: string(matches[3]),
		}
		nodes[nodeName] = newNode

		if nodeName[len(nodeName)-1] == 'A' {
			currentNodes = append(currentNodes, newNode)
		}
	}

	// TODO: not bruteforce algorithm
	for i := 0; ; i++ {
		instr := inputs.Day8[0][i%len(inputs.Day8[0])]

		found := 0
		for i, current := range currentNodes {
			nextStr := current.left
			if string(instr) == "R" {
				nextStr = current.right
			}

			if nextStr[len(nextStr)-1] == 'Z' {
				found++
			}

			currentNodes[i] = nodes[nextStr]
		}

		if found == len(currentNodes) {
			fmt.Println(i + 1)
			break
		}
	}
}
