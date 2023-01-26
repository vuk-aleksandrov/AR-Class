package com.example.arclass;

import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class CloudStorage {
    public static FirebaseStorage storage;
    public static StorageReference storageRef;

    public static void init() {
        storage=FirebaseStorage.getInstance("gs://test-b7c4a.appspot.com");
        storageRef=storage.getReference();
    }
}
