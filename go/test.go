// write all test codes here
package main
import ("fmt"
		"sort" // to get the datatype of the object
	);

func main() {
	var x []int;
	
	x = append(x, 3, 2, 9);
	sort.Sort(x)
	fmt.Fprintf(x)
}