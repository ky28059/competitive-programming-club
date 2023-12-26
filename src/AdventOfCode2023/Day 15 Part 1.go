package main

import (
	"./inputs"
	"./util"
	"fmt"
)

func main() {
	sum := int32(0)
	for _, s := range inputs.Day15 {
		sum += util.LabelHash(s)
	}
	fmt.Println(sum)
}
