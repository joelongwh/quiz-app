import React , {useState} from 'react'

const AddUser = (props) => {
    const[username, setUserename]=useState('')
    const[email, setEmail]=useState('')

    const onSubmit = (e) => {
        e.preventDefault()
        if (!username || !email) {
          alert('Please add an Exercise!')
          return
        }
        props.onAdd({username, email})
    }

    return(
        <form onSubmit={onSubmit}>
                <input type="text" placeholder="Enter your name" required="required" onChange={(e) => setUserename(e.target.value)} value ={username}/>
                <input type="text" placeholder="Enter your email" required="required" onChange={(e) => setEmail(e.target.value)} value ={email}/>
                <button type="submit"><span>Start</span></button>
            </form>
    );
}

export default AddUser