package main
import "fmt"

type  Node struct {
	val int
	next *Node
}

func Constructor() Node {
	return Node{}
}

func (this *Node) Push(x int)  {
    this.val = x;
}

func main() {
	obj := Constructor();
	fmt.Println(obj);
	obj.Push(2);
}