// Import the functions you need from the SDKs you need
import { initializeApp } from "firebase/app";
import { getFirestore } from '@firebase/firestore';
import { getDatabase } from "firebase/database";

const firebaseConfig = {
  apiKey: "AIzaSyDgiB0s6-SCNMuSpFMflC6HvlVr-MDR05w",
  authDomain: "reactquiz-2aff9.firebaseapp.com",
  projectId: "reactquiz-2aff9",
  storageBucket: "reactquiz-2aff9.appspot.com",
  messagingSenderId: "1016116296193",
  appId: "1:1016116296193:web:f8be3c3ff4d59d939c1e00",
  databaseURL:"https://reactquiz-2aff9-default-rtdb.asia-southeast1.firebasedatabase.app/"
};


export const app = initializeApp(firebaseConfig);
export const database= getFirestore(app);
export const db= getDatabase(app);
