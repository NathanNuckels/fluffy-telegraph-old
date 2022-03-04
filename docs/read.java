//Lets create data so we have some data to read later.
//This is just example objects form the docs jsut ignore it.

CollectionReference cities = db.collection("cities");
List<ApiFuture<WriteResult>> futures = new ArrayList<>();
futures.add(cities.document("SF").set(new City("San Francisco", "CA", "USA", false, 860000L,
    Arrays.asList("west_coast", "norcal"))));
futures.add(cities.document("LA").set(new City("Los Angeles", "CA", "USA", false, 3900000L,
    Arrays.asList("west_coast", "socal"))));
futures.add(cities.document("DC").set(new City("Washington D.C.", null, "USA", true, 680000L,
    Arrays.asList("east_coast"))));
futures.add(cities.document("TOK").set(new City("Tokyo", null, "Japan", true, 9000000L,
    Arrays.asList("kanto", "honshu"))));
futures.add(cities.document("BJ").set(new City("Beijing", null, "China", true, 21500000L,
    Arrays.asList("jingjinji", "hebei"))));
// (optional) block on operation
ApiFutures.allAsList(futures).get();//RetrieveDataSnippets.java



DocumentReference docRef = db.collection("cities").document("SF");
// asynchronously retrieve the document
ApiFuture<DocumentSnapshot> future = docRef.get();
// ...
// future.get() blocks on response
DocumentSnapshot document = future.get(); //wait untill done
if (document.exists()) {
  System.out.println("Document data: " + document.getData()); //getData. Exacticly what it sounds like
} else {
  System.out.println("No such document!");
}//RetrieveDataSnippets.java


//reading custom objects
DocumentReference docRef = db.collection("cities").document("BJ");
// asynchronously retrieve the document
ApiFuture<DocumentSnapshot> future = docRef.get();
// block on response
DocumentSnapshot document = future.get();
City city = null; //Get a city varible ready.
if (document.exists()) {
  // convert document to POJO
  city = document.toObject(City.class);  //ooo cool. you just ask it to convert it to a thing and it does.
  System.out.println(city);
} else {
  System.out.println("No such document!");
}//RetrieveDataSnippets.java

//get all documents in a collection

//asynchronously retrieve all documents
ApiFuture<QuerySnapshot> future = db.collection("cities").get();
// future.get() blocks on response
List<QueryDocumentSnapshot> documents = future.get().getDocuments();
for (QueryDocumentSnapshot document : documents) {
  System.out.println(document.getId() + " => " + document.toObject(City.class));
}//RetrieveDataSnippets.java

//get a docuent's sub collections

Iterable<CollectionReference> collections =
    db.collection("cities").document("SF").listCollections();

for (CollectionReference collRef : collections) {
  System.out.println("Found subcollection with id: " + collRef.getId());
}//RetrieveDataSnippets.java
