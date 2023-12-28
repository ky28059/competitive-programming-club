package main

import (
	"./inputs"
	"./util"
	. "./util"
	"fmt"
	"time"
)

func main() {
	// https://stackoverflow.com/questions/39804861/what-is-a-concise-way-to-create-a-2d-slice-in-go
	e := make([][]bool, len(inputs.Day16))
	for i := range e {
		e[i] = make([]bool, len(inputs.Day16[0]))
	}

	// Launch beam routines in a goroutine (that itself launches goroutines).
	// Uses goroutine spawning because regular recursion reaches stack overflow on actual input.
	c := make(chan Point[int])
	go followBeam(c, 0, 0, 0, 1)

	// Continuously pull points from the channel, blow up after 5 seconds to give routines enough time to run
	// (because there's no good signal here for when to close the channel on the `followBeam` end)
	// TODO: works, but incredibly hacky
	timeout := time.After(5 * time.Second)
	for {
		select {
		case p := <-c:
			e[p.I][p.J] = true
		case <-timeout:
			// Write to file for debugging
			util.WriteMapFile(e, "day16.out")

			count := 0
			for _, row := range e {
				for _, b := range row {
					if b {
						count++
					}
				}
			}
			fmt.Println(count)
			return
		}
	}
}

func followBeam(c chan Point[int], i, j, iDir, jDir int) {
	if i < 0 || i >= len(inputs.Day16) || j < 0 || j >= len(inputs.Day16[0]) {
		return
	}
	c <- Point[int]{I: i, J: j}

	// Check special objects
	switch inputs.Day16[i][j] {
	case '|': // Vertical splitter
		if iDir != 0 {
			break
		}
		go followBeam(c, i+1, j, 1, 0)
		go followBeam(c, i-1, j, -1, 0)
		return
	case '-': // Horizontal splitter
		if jDir != 0 {
			break
		}
		go followBeam(c, i, j+1, 0, 1)
		go followBeam(c, i, j-1, 0, -1)
		return
	case '/':
		switch {
		case iDir < 0:
			go followBeam(c, i, j+1, 0, 1)
		case iDir > 0:
			go followBeam(c, i, j-1, 0, -1)
		case jDir < 0:
			go followBeam(c, i+1, j, 1, 0)
		case jDir > 0:
			go followBeam(c, i-1, j, -1, 0)
		}
		return
	case '\\':
		switch {
		case iDir < 0:
			go followBeam(c, i, j-1, 0, -1)
		case iDir > 0:
			go followBeam(c, i, j+1, 0, 1)
		case jDir < 0:
			go followBeam(c, i-1, j, -1, 0)
		case jDir > 0:
			go followBeam(c, i+1, j, 1, 0)
		}
		return
	}

	// Otherwise, keep going in laser direction
	go followBeam(c, i+iDir, j+jDir, iDir, jDir)
}
