import SwiftUI
import shared

// petstore sample
struct ContentView: View {
	let greet = Greeting().greeting()

	var body: some View {
        Text(greet).onAppear(perform: {
            Greeting().getPet { (response, error) in
                // causes the propagation crash if error is returned
                response?.body(completionHandler: { (pet, bodyerror) in
                    print(pet)
                    print(bodyerror)
                })
                print(response)
                print(error)
            }
            
//            Greeting().getSomething { (petname, error) in
//                print(petname)
//                print(error)
//            }
        })
	}
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
	ContentView()
	}
}
