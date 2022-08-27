import React, { useEffect, useState } from "react";
import { BASE_URL } from "../data/Connection";
import Header from "../components/Header";
import CardAddToNewOrExistingTopic from "./CardJS/CardAddToNewOrExistingTopic";

const AddToNewOrExistingTopic = () => {

    const[topics, setTopics] = useState([])
    let name = sessionStorage.getItem("name");

    useEffect(()=>{
        refresh();
    },[])

    const refresh = () =>{
        const requestOptions = {
        method: 'GET',
        headers: { 
            'Content-Type': 'application/json',
        },
        mode: 'cors'
        };
        const endpoint = BASE_URL + 'topic/select'
        console.log("Endpoint: " +  endpoint)
        fetch(endpoint, requestOptions)
            .then(response => response.json()) 
            .then(data => setTopics(data))
            .catch(error=> console.error(error)); 
    }

    const NewTopic = () => {
        window.location.href = "create/new"
    }

    const ExistingTopic = () => {
        window.location.href = "create/existing"
    }

    return(
        <CardAddToNewOrExistingTopic>
        <div>
            <Header/>
            <h3 className="welcome">Welcome {name}</h3>
            <h2 className="listtopic">List of topics here:</h2>
            {topics.map((topic => <div  key={topic.id} value={topic.id} className="topics">{topic.title}</div>))}            
            <button className="newtopicbutton" onClick={NewTopic}>New Topic</button>
            <div className="divider"></div>
            <button className="existingtopicbutton" onClick={ExistingTopic}>Existing Topic</button>
        </div></CardAddToNewOrExistingTopic>
    );
}

export default AddToNewOrExistingTopic