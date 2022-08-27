import React, { useCallback, useRef } from "react";
import"../pages/CardJS/CardAttemptQuestions";

const QuestionRow = ({question, handleOptionSelectedMethod}) => {
  
  const button1ref = useRef()
  const button2ref = useRef()
  const button3ref = useRef()
  const button4ref = useRef()
  
  const handleInput = useCallback((e) => {
    handleOptionSelectedMethod(e.target.value, question.answer.toString());
    button1ref.current.disabled = true
    button2ref.current.disabled = true
    button3ref.current.disabled = true
    button4ref.current.disabled = true
  }, []);
  
  return(
    <>
      <p className="questions">{question.question}</p>
      <div className="">
        <button
          className="submitbutton"
          name={`${question.id}`}
          value="1"
          onClick={e => handleInput(e, "value", "name")}
          ref = {button1ref}>
          {question.option_1}
        </button>
      </div>
      <div className="">
        <button
          className="submitbutton"
          name={`${question.id}`}
          value="2"
          onClick={e => handleInput(e, "value", "name")}
          ref = {button2ref}>
          {question.option_2}
        </button>
      </div>
      <div className="">
        <button
          className="submitbutton"
          name={`${question.id}`}
          value="3"
          onClick={e => handleInput(e, "value", "name")}
          ref = {button3ref}>
          {question.option_3}
        </button>
      </div>
      <div className="">
        <button
          className="submitbutton"
          name={`${question.id}`}
          value="4"
          onClick={e => handleInput(e, "value", "name")}
          ref = {button4ref}>
          {question.option_4}
        </button>
      </div>
    </>
  )
}

export default QuestionRow;