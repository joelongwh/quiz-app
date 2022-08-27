import React from 'react'
import TopicUserSub from './Topic_UserSub'
const TopicUser = (props) => {
    return(
      <div className="table">
        <table width="500" border="1">
                <thead>
                    <tr>
                        <th width="500" border="1">Name</th>
                        <th align="right">Score</th>
                    </tr>
                </thead>
            </table>
          {props.topic_user.map((user) => (
             <TopicUserSub  key={user.id} user={user}/>
          ))}
        </div>
    )
}
export default TopicUser