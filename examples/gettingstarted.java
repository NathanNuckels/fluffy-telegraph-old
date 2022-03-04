//Man this file is very orange.

//IF THIS CODE DOES NOT RUN CORRECTLY I DONT CARE
//Its ssupposed to be a collection of small code
//that I can copy paste
//Becasue I have to do a lot of my code on an IPhone :(

//Add firebase useing a servace account key.

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;

import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

// Use a service account
class StuffAndThings {
  InputStream serviceAccount = new FileInputStream("path/to/serviceAccount.json");
  GoogleCredentials credentials = GoogleCredentials.fromStream(serviceAccount);
  FirebaseOptions options = new FirebaseOptions.Builder()
      .setCredentials(credentials)
      .build();
  FirebaseApp.initializeApp(options);

  Firestore db = FirestoreClient.getFirestore(); //This line looks simaler to python...
  
  
  //Add stuff
  //                          colleciton              documet
  DocumentReference docRef = db.collection("users").document("aturing");
  // Add document data with an additional field ("middle") 
  
  Map<String, Object> data = new HashMap<>(); //What the f--- is a hash map
  data.put("first", "Alan");   //I guess its like a python dictionary????
  data.put("middle", "Mathison");
  data.put("last", "Turing");
  data.put("born", 1912); //Yes. Thats definitly what it is.
  //The actual code that writes the data is  |
  //                                THIS     V
  ApiFuture<WriteResult> result = docRef.set(data);  //The only reason this line does it it takes the result of the...
  System.out.println("Update time : " + result.get().getUpdateTime()); //...writing of stuff and tells you how long it took
  
  //Read stuff
  
  // asynchronously retrieve all users
  //why ASync? Does it really take that long??
  ApiFuture<QuerySnapshot> query = db.collection("users").get();
  // ...
  // query.get() blocks on response
  QuerySnapshot querySnapshot = query.get();
  List<QueryDocumentSnapshot> documents = querySnapshot.getDocuments(); //Gets  list of documents in the collection
  for (QueryDocumentSnapshot document : documents) {  //for document in documents:
    System.out.println("User: " + document.getId());   //displays document name
    System.out.println("First: " + document.getString("first"));  //Displays *string* feild "first"
    if (document.contains("middle")) {   //IF theres a middle
      System.out.println("Middle: " + document.getString("middle")); //display it
    }
    System.out.println("Last: " + document.getString("last"));
    System.out.println("Born: " + document.getLong("born"));  //displays *long* feild named "born"
    //A long is a number.
    //an int has 32 bits
    //a long has 64 i think
    //theres are also shorts (16 bit)
    //and alos long longs (128 bit) for those beeg numbers
  }


