import React, { useEffect, useState } from "react";
import CreateQuestion from "../components/CreateQuestion";
import { BASE_URL } from "../data/Connection";
import CardCreate from "./CardJS/CardCreate";
import "./CSS/CreateNewQuestion.css"
import Header from "../components/Header";

const AddQuestionToExistingTopic = () => {
    const[topics, setTopics] = useState([])
    const[questions, setQuestions] = useState([])
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
        };
        const endpoint = BASE_URL + 'topic/select'
        console.log("Endpoint: " +  endpoint)
        fetch(endpoint, requestOptions)
            .then(response => response.json()) 
            .then(data => setTopics(data)); 
      }
    const handleSelect=e=>{
      const{value}=e.target;
      sessionStorage.setItem("topic_id", value)
      console.log({value})
    }
    const AddQuestion = (question) => {
      let id = sessionStorage.getItem("topic_id")
      question = {
        ...question, topic : {id:id}
      }
      const requestOptions = {
        method: 'POST',
        headers: { 
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(question)
      };
      const endpoint = BASE_URL + "question"
      fetch(endpoint, requestOptions)
      .then(response => response.json()) 
      .then(data => setQuestions([...questions, data])); 
      window.alert("Question saved!")
    }
    return (
      <CardCreate>
        <Header/>
      <div>
      <h1 className="header">Welcome {name}</h1>
      <h2 className="header">Choose Topic</h2>
          <div className="select">
          <select className="dropdownlist" onChange={handleSelect}>
          <option  value={topics}>Select a topic</option>
          {topics.map((topic => <option key={topic.id} value={topic.id}>{topic.title}</option>))}
        </select>
        </div>
        <CreateQuestion onAdd={AddQuestion}/>
      </div>
      </CardCreate>
    );
}
export default AddQuestionToExistingTopic