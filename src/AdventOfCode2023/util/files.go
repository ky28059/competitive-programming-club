package util

import (
	"../inputs"
	"os"
)

func WriteMapFile(m [][]bool, path string) {
	f, _ := os.Create(inputs.BasePath + "/" + path)
	for _, t := range m {
		f.Write(append(Map(t, func(t bool) byte {
			if t {
				return '#'
			} else {
				return '.'
			}
		}), '\n'))
	}
}
