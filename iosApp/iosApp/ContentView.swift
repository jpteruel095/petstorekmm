import SwiftUI
import shared

// petstore sample
struct ContentView: View {
	let greet = Greeting().greeting()

	var body: some View {
        Text(greet).onAppear(perform: {
            PSService().getPetById(petId: 1) { (response, error) in
                // causes the propagation crash if error is returned
                response?.body(completionHandler: { (pet, bodyerror) in
                    print(pet)
                    print(bodyerror)
                })
                print(response)
                print(error)
            }
        })
	}
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
	ContentView()
	}
}
