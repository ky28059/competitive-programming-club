package util

func RollNorth(m [][]uint8) {
	for i, row := range m {
		for j, c := range row {
			if c != 'O' {
				continue
			}

			offset := 0
			for ; i-offset-1 >= 0; offset++ {
				if m[i-offset-1][j] != '.' {
					break
				}
			}
			m[i][j] = '.'
			m[i-offset][j] = 'O'
		}
	}
}

func RollSouth(m [][]uint8) {
	for i := len(m) - 1; i >= 0; i-- {
		for j, c := range m[i] {
			if c != 'O' {
				continue
			}

			offset := 0
			for ; i+offset+1 < len(m); offset++ {
				if m[i+offset+1][j] != '.' {
					break
				}
			}
			m[i][j] = '.'
			m[i+offset][j] = 'O'
		}
	}
}

func RollWest(m [][]uint8) {
	for j := range m[0] {
		for i := range m {
			if m[i][j] != 'O' {
				continue
			}

			offset := 0
			for ; j-offset-1 >= 0; offset++ {
				if m[i][j-offset-1] != '.' {
					break
				}
			}
			m[i][j] = '.'
			m[i][j-offset] = 'O'
		}
	}
}

func RollEast(m [][]uint8) {
	for j := len(m[0]) - 1; j >= 0; j-- {
		for i := range m {
			if m[i][j] != 'O' {
				continue
			}

			offset := 0
			for ; j+offset+1 < len(m[0]); offset++ {
				if m[i][j+offset+1] != '.' {
					break
				}
			}
			m[i][j] = '.'
			m[i][j+offset] = 'O'
		}
	}
}

func CalculateLoad(m [][]uint8) (sum int) {
	for i, row := range m {
		for _, c := range row {
			if c == 'O' {
				sum += len(m) - i
			}
		}
	}
	return
}
