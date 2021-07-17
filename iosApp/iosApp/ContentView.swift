import SwiftUI
import shared

// petstore sample
struct ContentView: View {
    let petId: Int64 = 9223372000000186000
	var body: some View {
        Text("Pet Store Tester").onAppear(perform: {
            PetStoreService().getPetById(petId: petId) { (pet, bodyerror) in
                print(pet)
                print(bodyerror)
            }
        })
	}
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
	ContentView()
	}
}
