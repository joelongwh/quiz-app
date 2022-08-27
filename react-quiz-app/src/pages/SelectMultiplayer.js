import React, { useState } from "react";
import { db } from '../firebase-config';
import {uid} from "uid";
import { set, ref, onDisconnect } from "firebase/database";


const SelectMultiplayer = () => { 
 
    let topic_id= sessionStorage.getItem("topic_id");
    const [users]=useState([]);
    const [realName,setRealName]= useState('');
    const presenceRef= ref(db,"disconnectmessage");
    // const connectedRef= ref(db,".info/connected");
    // onValue(connectedRef, (snap) => {
    //     if (snap.val() === true) {
    //       console.log("connected");
    //     } else {
    //       console.log("not connected");
    //     }
    //   });
    onDisconnect(presenceRef).set("I disconnected!");
    onDisconnect(presenceRef).remove().catch((err)=>
    {if (err){
        console.error("could not establish onDisconnect event", err);
    }});
    //realtime crud
    //write

    

    const writeToDatabase=()=>{

            const uuid=uid();
                    set(ref(db,`users/${uuid}`),{
                        realName,
                        topic_id,
                        uuid,
                    })
                    
                    window.location.href = "topic/question"
            

        };

    return(
        
        <div>
            
            <input type="text"  placeholder="Name" value={realName} onChange={(event)=>{setRealName(event.target.value)}}/>
            <button onClick={writeToDatabase}>submit</button>
             
            <h2>List of users online</h2>
            {users.map((user)=>{
                return(
                    <div>
                        {" "}
                        <h1>Name:{users.user.realName}</h1>
                    </div>
                );
            })}
           
              
          
        </div>



        );}
    
export default SelectMultiplayer


//npm install firebase
//npm install uid