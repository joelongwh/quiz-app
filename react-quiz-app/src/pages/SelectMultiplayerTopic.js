import React, { useEffect, useState } from "react";
import { BASE_URL } from "../data/Connection";
import CardSelectTopic from "./CardJS/CardSelectTopic";
import "./CSS/SelectTopic.css"
import Header from "../components/Header";

const SelectMultiplayerTopic = () => {
  const[topics, setTopics] = useState([])
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
    const handleSelect=e=>{
      const{value}=e.target;
      sessionStorage.setItem("topic_id", value)
      console.log({value})
      window.location.href = "multiplayer"
    }
    return (
      <CardSelectTopic>
        <Header/>
        <div>
          <h1 className="selectheader">Welcome</h1>
          <form>
            <div>
            <h2 className="listtopic">List of topics here:</h2>
            </div>
            <select className="dropdownmenu" onChange={handleSelect} >
              <option value={topics}>Select a topic</option>
              {topics.map((topic => <option  key={topic.id} value={topic.id} >{topic.title}</option>))}
            </select>
          </form>
        </div>
      </CardSelectTopic>
    );
}
export default SelectMultiplayerTopic