import SwiftUI
import shared

// petstore sample
struct ContentView: View {
    let petId: Int64 = 1
    let service = PetStoreService()
	var body: some View {
        Text("Pet Store Tester").onAppear(perform: {
            service.getPetById(petId: petId, completionHandler: { (pet, bodyerror) in
                
                print(pet?.name)
                print(bodyerror)
            })
        })
	}
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
	ContentView()
	}
}
