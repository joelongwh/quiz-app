import React, { useEffect, useState, useRef } from "react";
import Card from "./CardJS/Card";
import "./CSS/Welcome.css"
import Header from "../components/Header";

const Welcome = () => {
	const [name, setName] = useState("");
	const [email, setEmail] = useState("");
	const inputRef = useRef();

	useEffect(() => {
		inputRef.current.focus();
	}, []);

	const onSubmit = (e) => {
		e.preventDefault();
		console.log(name)
		sessionStorage.setItem("name", name)
		sessionStorage.setItem("email", email)
		window.location.href = "topic";
	}

	const createQuestion = () => {
		sessionStorage.setItem("name", name)
		sessionStorage.setItem("email", email)
		window.location.href = "create";
	}

	const selectMultiplayerTopic = () => {
		sessionStorage.setItem("name", name)
		sessionStorage.setItem("email", email)
		window.location.href = "selectmultiplayertopic";
	}

	return (
		<Card>
			<Header/>
			<div>
				<h1 className="font-effect-fire-animation">You Smart or Not!</h1>
				<h2 className="primary_text">Please enter your name</h2>
				<form onSubmit={onSubmit}>
					<input ref={inputRef} type="text" placeholder="Enter your name" required="required" className="username_input" onChange={(e) => setName(e.target.value)} value={name} />
					<h2 className="primary_text">Please enter your email</h2>
					<input type="email" placeholder="Enter your email" required="required"  className="email_input" onChange={(e) => setEmail(e.target.value)} value={email} />
					<button type="submit" className="start_button"><span>Start</span></button>
				</form>
				<button onClick={() => createQuestion()} className="create_button">Create</button>
				<button onClick={() => selectMultiplayerTopic()} className="multiplayer_button">Multiplayer Mode</button>
			</div>
		</Card>
	);
}

export default Welcome;