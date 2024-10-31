import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import Trip from './Trip';
import App from './App';

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <>
  <div className='trip-box'>
  <App/>
  <div className='image-box'>
 <Trip/>
 </div>
 </div>
 </>
);

