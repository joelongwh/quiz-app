import React, { useEffect, useState } from "react";
import { BASE_URL } from "../data/Connection";
import QuestionRow from "../components/QuestionRow";
import CardAttemptQuestions from "./CardJS/CardAttemptQuestions";

const AttemptQuestion =() => {
  
  const[questions, setQuestions] = useState([]);
  const [currentQuestion, setCurrentQuestion] = useState(0);
  let domQuestions=[];
  let id = sessionStorage.getItem("topic_id");
  let name = sessionStorage.getItem("name");
  let email = sessionStorage.getItem("email");
  const [score, setScore] = useState(0);
  
  useEffect(()=>{
    refreshQuestions();
  },[])
  
  const refreshQuestions = () =>{
    const requestOptions = {
      method: 'GET',
      headers: {'Content-Type': 'application/json'},
    };
    const endpoint = BASE_URL + 'question/' + id
    console.log("Endpoint: " +  endpoint)
    fetch(endpoint, requestOptions)
      .then(response => response.json()) 
      .then(data => loadQuestions(data)); 
  }
  
  const handleOptionSelected = (selectedOption, correctOption) => {
    if (selectedOption === correctOption) {
      console.log('RIGHT')
      setScore(score + 1);
    } else {
      console.log('WRONG');
    }
    console.log('score', score);
    const nextQuestion = currentQuestion + 1;
    if (nextQuestion < questions.length) {
      setCurrentQuestion(nextQuestion);
    } else {
      if (selectedOption === correctOption) {
        sessionStorage.setItem("score", score+1)
        var user = {
        "username" : name,
        "email" : email,
        "score" : score+1
        }
      } else {
        sessionStorage.setItem("score", score)
        user = {
        "username" : name,
        "email" : email,
        "score" : score
        }
      }
      var endpoint = BASE_URL + "user/save?id=" + id
      const requestOptions = {
        method: 'POST',
        headers: { 
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(user)
      };
      fetch(endpoint, requestOptions)
      .then(response => response.json()) 
      .then(window.location.href="/result");
    }
  };
  
  const loadQuestions = (newQuestions) => {
    setQuestions(newQuestions);
  }
  
  domQuestions=[];
  for (let i=0; i<questions.length; i++){
    domQuestions.push(<QuestionRow key={i} question={questions[i]} handleOptionSelectedMethod = {handleOptionSelected} />)
  }
  
  return ( 
  <CardAttemptQuestions>
    <div>
      <div className='score-section'>
					SCORE: {score} / {questions.length}
			</div>
      <div className='question-section'>
        <div className='question-count'>
          <span>Question {currentQuestion + 1}</span>/{questions.length}
        </div>
        <div className='question-text'>{domQuestions[currentQuestion]}</div>
      </div>
    </div>
  </CardAttemptQuestions>
  );
}

export default AttemptQuestion