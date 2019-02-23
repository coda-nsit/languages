package main
import ("fmt"
		"math"
		"math/rand"
		"net/http"
		"io/ioutil")

func add(x,y float64) float64 {
	return x + y
}

func multiple(a,b string) (string, string) {
	return a, b
}

// ResponseWriter: writes to the web page
func index_handler(w http.ResponseWriter, r *http.Request) {
	fmt.Fprintf(w, "<h1>go is %s!</h1>", "<strong>neat</strong>")
}

func about_handler(w http.ResponseWriter, r *http.Request) {
	fmt.Fprintf(w, "go tutorial")
}

func webServer() {
	// when / is hit run index_handler function
	http.HandleFunc("/", index_handler)
	http.HandleFunc("/about/", about_handler)
	// run the http server at 8000
	http.ListenAndServe(":8000", nil)
}

type car struct {
	gas_pedal uint16
	brake_pedal uint16
	steering_pedal int16
	top_speed_kmh float64
}


// value reciever: just recieve values and does calculation on them and returns, 
// following is not a function
// here c is actual copy and not reference, so any change to c is not reflected in actual c 
func (c car) kmph() float64 {
	return float64(c.gas_pedal) * (c.top_speed_kmh / 65535)
}

// pointer reciever: if we need to change something
func (c *car) new_top_speed(newSpeed float64) {
	c.top_speed_kmh = newSpeed
}


func main(){
	// the functions that start with caps are imported so, all functions imported from a package will always be
	// caps since they are exported
	fmt.Println("the square root of 4 is", math.Sqrt(4));
	
	
	// we can write math/rand.Intn or math.rand.Intn we need to explicitely import
	fmt.Println("a random number between 1-100", rand.Intn(100));
	
	
	var x, y float64 = 3, 2
	const z  float64 = 23.2
	
	
	fmt.Println("addition result is", add(x, y))
	fmt.Println(multiple("hello", "world"))
	
	a    := 5
	addr := &a
	*addr = 7	

	aCar := car{22341, 0, 12562, 255.0}
	fmt.Println("struct value", aCar.gas_pedal)
	fmt.Println("kmph speed", aCar.kmph())
	aCar.new_top_speed(300)
	fmt.Println("kmph speed", aCar.top_speed_kmh)

	// resp, _  := http.Get("https://www.washingtonpost.com/news-sitemap-index.html")
	resp := `
		<sitemap>
      		<loc>http://www.washingtonpost.com/news-blogs-entertainment-sitemap.xml</loc>
   		</sitemap>
	   <sitemap>
	      <loc>http://www.washingtonpost.com/news-blogs-goingoutguide-sitemap.xml</loc>
	   </sitemap>
	   <sitemap>
	      <loc>http://www.washingtonpost.com/news-goingoutguide-sitemap.xml</loc>
	   </sitemap>
	`
	bytes, _ := ioutil.ReadAll(resp.Body)
	string_body := string(bytes)
	fmt.Println("string_body", string_body)
	// free up the resources that made the http request
	resp.Body.Close()
}