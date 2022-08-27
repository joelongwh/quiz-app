import React , { useState } from 'react'
import"./CreateQuestion.css";
const CreateQuestion = (props) => {
    const[question,setQuestion] = useState('')
    const[option_1,setOption_1] = useState('')
    const[option_2,setOption_2] = useState('')
    const[option_3,setOption_3] = useState('')
    const[option_4,setOption_4] = useState('')
    const[answer,setAnswer] = useState('')
    const onSubmit = (e) => {
        e.preventDefault()
        if (!question || !option_1 || !option_2 || !option_3 || !option_4 || !answer) {
          alert('Please fill in all fields')
          return
        }
        props.onAdd({question, option_1, option_2,option_3,option_4,answer})
        setQuestion('')
        setOption_1('')
        setOption_2('')
        setOption_3('')
        setOption_4('')
        setAnswer('')
    }
    return (
        <form onSubmit={onSubmit}>
            <div>
                <h2 className="primary_text">Question</h2>
                <input type="text" placeholder="Question" className="question_input"  onChange={(e) => setQuestion(e.target.value)} value={question}/>
            </div>
            <div>
                <h2 className="primary_text">Option 1</h2>
                <input type='text'className="option_input" placeholder='Option 1' value={option_1} onChange={(e) => setOption_1(e.target.value)}/>
            </div>
            <div>
                <h2 className="primary_text">Option 2</h2>
                <input type='text' className="option_input" placeholder='Option 2' value={option_2} onChange={(e) => setOption_2(e.target.value)}/>
            </div>
            <div>
                <h2 className="primary_text">Option 3</h2>
                <input type='text' className="option_input" placeholder='Option 3' value={option_3} onChange={(e) => setOption_3(e.target.value)}/>
            </div>
            <div>
                <h2 className="primary_text">Option 4</h2>
                <input type='text' className="option_input" placeholder='Option 4' value={option_4} onChange={(e) => setOption_4(e.target.value)}/>
            </div>
            <div>
             <h2 className="primary_text">Answer</h2>
             <label>
             <select className="answer_input" onChange={(e) => setAnswer(e.target.value)} value={answer} answer=" ">
             <option value=" ">Select Answer</option>
                <option value = "1">Option 1</option>
                <option value = "2">Option 2</option>
                <option value = "3">Option 3</option>
                <option value = "4">Option 4</option>
             </select>
             </label>
            </div>
            <input type='submit' value='Save Question' className='submission'></input>
        </form>
    );
}
export default CreateQuestion