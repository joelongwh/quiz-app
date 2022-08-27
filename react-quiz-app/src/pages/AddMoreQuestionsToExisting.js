import React, { useEffect, useState } from "react";
import { BASE_URL } from "../data/Connection";
import CreateQuestion from "../components/CreateQuestion";
import CardCreate from "./CardJS/CardCreate";

const AddMoreQuestionsToExisting = () => {
    const[id, setId] = useState()
    const[questions, setQuestions] = useState([])
    const[count, setCount] = useState(2)

    useEffect(()=>{
      refresh();
    },[])

    const refresh = () =>{
      let title = sessionStorage.getItem("title")
      const requestOptions = {
        method: 'GET',
        headers: { 
          'Content-Type': 'application/json',
        },
        mode: 'cors'
      };
      const endpoint = BASE_URL + 'topic/' + title
      console.log("Endpoint: " +  endpoint)
      fetch(endpoint, requestOptions)
          .then(response => response.json()) 
          .then(data => setId(data)); 
    }

    const countQuestionsCreated = () => {
      setCount(count + 1);
    }

    const redirect =() => {
      let title = sessionStorage.getItem("title")
      window.alert("Created 5 questions for topic title: " + title + "\n Redirecting to Home" ) 
      window.location.href="/"
    }

    const AddQuestion = (question) => {
    countQuestionsCreated();

      if (count < 5)
      { 
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
      ;} else { 
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
        redirect();
      }
  }

      return(
        <CardCreate>

        
        <div>
        <div className='question-count'>
          <span>Question: {count}</span>/5
        </div>
            <CreateQuestion onAdd={AddQuestion}/>
        </div>
        </CardCreate>
    );
}

export default AddMoreQuestionsToExisting