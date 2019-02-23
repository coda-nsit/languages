package main
import "fmt"

func main() {
	var m map[int]int
	m = make(map[int]int)
	m[2] = 2

	var arr [16]int
	for i := 0; i < 15; i++ {
		arr[i] = (1 << uint(i))
		fmt.Println(arr[i])
	}

	for index, element := range arr {
		fmt.Println(index, element)
	}

	for true {
		fmt.Println(2**3)
	}
}i