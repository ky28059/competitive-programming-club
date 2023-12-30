package main

import (
	"fmt"
	"sort"
)

type indexedNum struct {
	n int
	i int
}

func main() {
	var t int
	fmt.Scanln(&t)

	// Read in input and sort, remembering the order to print by later
	in := make([]indexedNum, t)
	for i := 0; i < t; i++ {
		var n int
		fmt.Scanln(&n)
		in[i] = indexedNum{n, i}
	}
	sort.Slice(in, func(i, j int) bool { // Note: would use `slices.SortFunc` if Go version was higher
		return in[i].n < in[j].n
	})

	out := make([]int64, t)

	fac := int64(1)
	for num, i := 0, 0; num <= in[len(in)-1].n; num++ {
		if num != 0 {
			fac = (fac * int64(num)) % 998244353
		}

		if num == in[i].n {
			out[in[i].i] = fac
			i++
		}
	}

	for _, f := range out {
		fmt.Println(f)
	}
}
