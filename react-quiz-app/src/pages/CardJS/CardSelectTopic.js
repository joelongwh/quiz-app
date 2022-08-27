import React from "react";
import "../CardCSS/CardSelectTopic.css";
const CardSelectTopic = (props) => {
    return <div className="cardselecttopic">{props.children}</div>;
};
export default CardSelectTopic;