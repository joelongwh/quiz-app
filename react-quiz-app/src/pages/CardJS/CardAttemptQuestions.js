import React from "react";

import "../CardCSS/CardAttemptQuestions.css";

const CardAttemptQuestions = (props) => {
	return <div className="cardattemptquestions">{props.children}</div>;
};

export default CardAttemptQuestions;