import React, { Component } from 'react';
import PaddockStatus from './park_view/PaddockStatus';
import ParkStatus from './park_view/ParkStatus';
import VisitorCount from './park_view/VisitorCount';

class ParkView extends Component {
  constructor(props){
    super(props)
    this.state = {park_open: [], rampaging: []}
    this.handleParkOpen = this.handleParkOpen.bind(this);
  }

  handleParkOpen(open, rampage){
    if(open){
      this.setState({park_open: true})
    }
    else{
      this.setState({park_open: false})
    }

    if(rampage){
      this.setState({rampaging: true})
    }
    else{
      this.setState({rampaging: false})
    }
  }

  render() {
    return (
        <>
          <h2>ParkView</h2>
          <div id="park_info">
          <VisitorCount open = {this.state.park_open} rampaging = {this.state.rampaging}/>
          <ParkStatus open = {this.state.park_open} rampaging = {this.state.rampaging} handleParkOpen = {this.handleParkOpen}/>
          </div>
          <PaddockStatus />
        </>
    );
  }
}

export default ParkView;
