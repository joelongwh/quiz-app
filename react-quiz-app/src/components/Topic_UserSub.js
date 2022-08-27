import React from 'react'
import"./CreateQuestion.css";

const TopicUserSub = (props) => {
    return (
        <div className="table">
            <table width="500" border="1">
                <tbody>
                    <td width="407" border="1">{props.user.username}</td>
                    <td align="center">{props.user.score}</td>
                </tbody>
            </table>
        </div>
    );
}
export default TopicUserSub