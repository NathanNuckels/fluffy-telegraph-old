//Im super excited for this one because you cant do this in python!!

DocumentReference docRef = db.collection("cities").document("SF");
docRef.addSnapshotListener(new EventListener<DocumentSnapshot>() { //Add a litner
  @Override
  public void onEvent(@Nullable DocumentSnapshot snapshot,  //(1) when somthing happens...
                      @Nullable FirestoreException e) {
    if (e != null) {
      System.err.println("Listen failed: " + e); //(3) but if google f---s up, tell the user somthing else
      return;
    }

    if (snapshot != null && snapshot.exists()) {
      System.out.println("Current data: " + snapshot.getData());  //(2) Tell the user....
    } else {
      System.out.print("Current data: null");
    }
  }
});//ListenDataSnippets.java
