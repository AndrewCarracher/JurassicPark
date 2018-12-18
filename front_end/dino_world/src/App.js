import React, { Component } from 'react';
import Header from './components/Header';
import Navbar from './components/Navbar';
import ParkView from './containers/ParkView';
import './App.css';

class App extends Component {
  render() {
    return (
        <>
          <Header />
          <Navbar />
          <ParkView />
        </>
    );
  }
}

export default App;
