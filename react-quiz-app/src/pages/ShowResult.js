import React from "react";
import Header from "../components/Header";
import Card from "./CardJS/Card";
import "./CSS/ShowResult.css"
const ShowResult = () => {

    let name = sessionStorage.getItem("name");
    let score = sessionStorage.getItem("score");

    return (
        <Card>
        <div>
            <Header/>
            <p></p>
            <div className="header">
            Well done {name}, your score is:
            <h1>{score}</h1>
            </div>
        </div>
        </Card>
    );
}

export default ShowResult