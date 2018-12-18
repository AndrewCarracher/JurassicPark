import React, { Component } from 'react';
import Header from './components/Header';
import Navbar from './components/Navbar';
import ParkView from './containers/ParkView';
import PaddockView from './containers/PaddockView';
import DinosaurView from './containers/DinosaurView';
import './App.css';
import { BrowserRouter as Router, Route } from "react-router-dom";

class App extends Component {
  render() {
    return (
        <>
          <Header />

          <Router>
            <>
              <Navbar />
              <Route exact path="/park_overview" component={ParkView} />
              <Route exact path="/paddocks_overview" component={PaddockView} />
              <Route exact path="/dinosaurs_overview" component={DinosaurView} />
            </>
          </Router>


        </>
    );
  }
}

export default App;
