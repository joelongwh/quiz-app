import React from 'react'
import { AiTwotoneHome } from 'react-icons/ai'
import { MdLeaderboard } from 'react-icons/md'

const Header = () => {
  return (
    <header className='font-effect-3d-float'>
      <li><a href="/"><AiTwotoneHome/>Home</a></li>
      <li><a href="/leaderboard"><MdLeaderboard/>LeaderBoard</a></li>
    </header>
  )
}

export default Header