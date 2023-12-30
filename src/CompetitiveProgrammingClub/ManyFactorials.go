package main

import "fmt"

func main() {
	// Initialize prefix sums; use slices to avoid heap memory issue
	facs := make([]uint32, 998244353)
	facs[0] = 1
	for i := uint32(1); i < 998244353; i++ {
		facs[i] = (facs[i-1] * i) % 998244353
	}

	var t int
	fmt.Scanln(&t)

	for i := 0; i < t; i++ {
		var n int
		fmt.Scanln(&n)
		fmt.Println(facs[n])
	}
}
