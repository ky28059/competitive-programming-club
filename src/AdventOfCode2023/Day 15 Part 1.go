package main

import (
	"./inputs"
	"./util"
	"fmt"
)

func main() {
	fmt.Println(util.SumOf(inputs.Day15, func(s string) int32 {
		return util.LabelHash(s)
	}))
}
