package main

import (
	"fmt"
)

func main()  {
	fmt.Println("你好，世界")

	type Person struct {
		Name string
		Age  int
		Sex  int
	}

	p := &Person{"polaris", 28, 0}
	fmt.Println(p)
	fmt.Println(p.Name)
	
}