//delete a doc

// asynchronously delete a document
ApiFuture<WriteResult> writeResult = db.collection("cities").document("DC").delete();
// ...
System.out.println("Update time : " + writeResult.get().getUpdateTime());//ManageDataSnippets.java

