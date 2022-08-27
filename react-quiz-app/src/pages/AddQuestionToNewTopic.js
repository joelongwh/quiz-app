import React, { useState } from "react";
import { BASE_URL } from "../data/Connection";
import CreateQuestion from "../components/CreateQuestion";
import Header from "../components/Header";
import CardCreate from "./CardJS/CardCreate";


const AddQuestionToNewTopic = () => {
    const[questions, setQuestions] = useState([])
    const[title, setTitle] = useState('')

    const AddQuestion = (question) => {
        if (title !== ''){
        question = {
          ...question, topic : {title:title}
        }
        const requestOptions = {
          method: 'POST',
          headers: { 
            'Content-Type': 'application/json',
          },
          body: JSON.stringify(question)
        };
        const endpoint = BASE_URL + "question/new"
        fetch(endpoint, requestOptions)
        .then(response => response.json()) 
        .then(data => setQuestions([...questions, data])); 
        sessionStorage.setItem("title", title)
        window.location.href = "new/questions"
      } else {
        alert("Please enter a topic title")
      }
    }
    return(
      <CardCreate>
        <div>
            <Header/>
            <div className='question-count'>
              <span>Question: 1</span>/5
           </div>
            <div>
            <h2 className="primary_text">Topic</h2>
            <input required="required" type="text" placeholder="Topic" className="topic_input" value={title} onChange={(e) => setTitle(e.target.value)}/>
            </div>
            <CreateQuestion onAdd={AddQuestion}/>
        </div>
        </CardCreate>
    );
}

export default AddQuestionToNewTopic