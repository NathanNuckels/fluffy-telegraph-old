

// Create a Map to store the data we want to set
Map<String, Object> docData = new HashMap<>(); //docData={
docData.put("name", "Los Angeles");  //"name":"Los Angeles", 
docData.put("state", "CA");
docData.put("country", "USA");
docData.put("regions", Arrays.asList("west_coast", "socal"));  //"reigions"=["west_coast","social"]
// Add a new document (asynchronously) in collection "cities" with id "LA"
ApiFuture<WriteResult> future = db.collection("cities").document("LA").set(docData);
// everything right of the equals sign is the exact same as in python.

// ...
// future.get() blocks on response (I think this means "Wait for response")
System.out.println("Update time : " + future.get().getUpdateTime());//ManageDataSnippets.java
//I think this waits for the asuncrounus thing to finish, therefore makeing it syncrounus lol
//sorry for spelling. English is my first language.

//Data types.

Map<String, Object> docData = new HashMap<>();
docData.put("stringExample", "Hello, World");
docData.put("booleanExample", false);
docData.put("numberExample", 3.14159265);
docData.put("nullExample", null); //I didn't know you could do that. cool.

ArrayList<Object> arrayExample = new ArrayList<>();
Collections.addAll(arrayExample, 5L, true, "hello"); //what does 5L mean
docData.put("arrayExample", arrayExample); // .put is the same as python .append

Map<String, Object> objectExample = new HashMap<>();
objectExample.put("a", 5L);  //What the heck is 5L??!?? Is it shorthand for the datatype "long"???
objectExample.put("b", true);

docData.put("objectExample", objectExample);

ApiFuture<WriteResult> future = db.collection("data").document("one").set(docData);
System.out.println("Update time : " + future.get().getUpdateTime());//ManageDataSnippets.java


//Custom objects!

public City() {
  // Must have a public no-argument constructor
}

// Initialize all fields of a city
public City(String name, String state, String country,
            Boolean capital, Long population, List<String> regions) {
  this.name = name;
  this.state = state;
  this.country = country;
  this.capital = capital;
  this.population = population;
  this.regions = regions;
}//City.java

City city = new City("Los Angeles", "CA", "USA", false, 3900000L, //L definitly means long.
    Arrays.asList("west_coast", "socal"));
ApiFuture<WriteResult> future = db.collection("cities").document("LA").set(city);
// block on response if required
System.out.println("Update time : " + future.get().getUpdateTime());//ManageDataSnippets.java


//Autogenerated ids

// Add document data with auto-generated id.
Map<String, Object> data = new HashMap<>();
data.put("name", "Tokyo");
data.put("country", "Japan");
ApiFuture<DocumentReference> addedDocRef = db.collection("cities").add(data);
//                                                                  ^  this thing right here
System.out.println("Added document with ID: " + addedDocRef.get().getId());//ManageDataSnippets.java


// .update   (Literly the same as pyhon)

// Update an existing document
DocumentReference docRef = db.collection("cities").document("DC");

// (async) Update one field
ApiFuture<WriteResult> future = docRef.update("capital", true);

// ...
WriteResult result = future.get();
System.out.println("Write result: " + result);//ManageDataSnippets.java


//Server timestamp. Thi sis so usefull why don't we have this in python
DocumentReference docRef = db.collection("objects").document("some-id");
// Update the timestamp field with the value from the server
ApiFuture<WriteResult> writeResult = docRef.update("timestamp", FieldValue.serverTimestamp());
                                                                    //^ this
System.out.println("Update time : " + writeResult.get());//ManageDataSnippets.java



//update elements in an array

DocumentReference washingtonRef = db.collection("cities").document("DC");

// Atomically add a new region to the "regions" array field.
ApiFuture<WriteResult> arrayUnion = washingtonRef.update("regions",FieldValue.arrayUnion("greater_virginia"));
                                                                      //here
System.out.println("Update time : " + arrayUnion.get());

// Atomically remove a region from the "regions" array field.
ApiFuture<WriteResult> arrayRm = washingtonRef.update("regions",FieldValue.arrayRemove("east_coast"));
                                                                                //here
System.out.println("Update time : " + arrayRm.get());//ManageDataSnippets.java


