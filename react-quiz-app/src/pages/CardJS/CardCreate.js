import React from "react";

import "../CardCSS/CardCreate.css";

const Card = (props) => {
	return <div className="cardcreate">{props.children}</div>;
};

export default Card;