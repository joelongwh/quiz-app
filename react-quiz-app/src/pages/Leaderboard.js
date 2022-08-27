import React, { useEffect, useState } from "react";
import { BASE_URL } from "../data/Connection";
import TopicUser from "../components/Topic_User";
import CardCreate from "./CardJS/CardCreate";
import Header from "../components/Header";
import "./CSS/SelectTopic.css"

const LeaderBoard = () => {
    const[topics, setTopics] = useState([])
    const[user,setUsers] = useState([])
    useEffect(()=>{
        refresh();
      },[])
      const refresh = () =>{
        const requestOptions = {
          method: 'GET',
          headers: { 
            'Content-Type': 'application/json',
          },
        };
        const endpoint = BASE_URL + 'topic/select'
        console.log("Endpoint: " +  endpoint)
        fetch(endpoint, requestOptions)
            .then(response => response.json()) 
            .then(data => setTopics(data)); 
      }
    const handleSelect = (e) =>{
      const{value}=e.target;
      console.log(value)
      const requestOptions = {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json',
        },
    };
    const endpoint = BASE_URL + 'user/' + value;
    console.log("Endpoint: " + endpoint)
    fetch(endpoint, requestOptions)
        .then(response => response.json())
        .then(data => setUsers(data));
      sessionStorage.setItem("topic_id", value)
    }
    return (
      <CardCreate>
        <Header/>
          <div>
              <h1 className="header">SMART PEOPLE</h1>
              <h2 className="header">Choose topic leaderboard:</h2>
              <br></br>
            <select className="dropdownmenu" onChange={handleSelect}>
            <option value={topics}>---Select a topic---</option>
            {topics.map((topic => <option key={topic.id} value={topic.id}>{topic.title}</option>))}
          </select>
          <TopicUser topic_user={user} />
          </div>
      </CardCreate>
    );
}
export default LeaderBoard