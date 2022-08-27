import React from 'react';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import SelectTopic from './pages/SelectTopic';
import Welcome from './pages/Welcome';
import AttemptQuestion from './pages/AttemptQuestion';
import AddToNewOrExistingTopic from './pages/AddToNewOrExistingTopic';
import AddQuestionToExistingTopic from './pages/AddQuestionToExistingTopic';
import AddMoreQuestionsToExisting from './pages/AddMoreQuestionsToExisting';
import LeaderBoard from './pages/Leaderboard';
import ShowResult from './pages/ShowResult';
import AddQuestionToNewTopic from './pages/AddQuestionToNewTopic';
import SelectMultiplayer from './pages/SelectMultiplayer';
import SelectMultiplayerTopic from './pages/SelectMultiplayerTopic';

function App() {
  return (
    <BrowserRouter>
    <Routes>
      <Route path="/" element={<Welcome/>} />
      <Route path="/topic" element={<SelectTopic/>} />
      <Route path="/topic/question" element={<AttemptQuestion/>} />
      <Route path="/create" element={<AddToNewOrExistingTopic/>} />
      <Route path="/create/new" element={<AddQuestionToNewTopic/>} />
      <Route path="/create/new/questions" element={<AddMoreQuestionsToExisting/>} />
      <Route path="/create/existing" element={<AddQuestionToExistingTopic/>} />
      <Route path="/result" element={<ShowResult/>} />
      <Route path="/leaderboard" element={<LeaderBoard/>} />
      <Route path="/multiplayer" element={<SelectMultiplayer/>}/>
      <Route path="/selectmultiplayertopic" element={<SelectMultiplayerTopic/>}/>

    </Routes>
  </BrowserRouter>
  );
}

export default App;
