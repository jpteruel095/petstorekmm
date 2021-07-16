import SwiftUI
import shared

// petstore sample
struct ContentView: View {

	var body: some View {
        Text("Pet Tester").onAppear(perform: {
            PetService().fetchPet { (response, error) in
                response?.body(completionHandler: { (pet, bodyerror) in
                    print(pet)
                    print(bodyerror)
                    
                    print("Pet name:")
                    print(pet?.name)
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
