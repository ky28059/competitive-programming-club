package util

func LabelHash(s string) (current int32) {
	for _, c := range s {
		current += c
		current *= 17
		current %= 256
	}
	return
}
