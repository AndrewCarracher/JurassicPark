import React, { Component } from 'react';
import Request from '../../helpers/request';
import ParkBoxStatus from '../../components/park_view/ParkBoxStatus';
import RampageBoxStatus from '../../components/park_view/RampageBoxStatus';

class ParkStatus extends Component {
  constructor(props){
    super(props);
    this.state = {park_open: [], rampaging: []}
    this.changeParkOpen = this.changeParkOpen.bind(this);
    this.changeRampageStatus = this.changeRampageStatus.bind(this);
    // console.log(this.props);
  }

  componentDidMount(){
    const request = new Request();
    request.get("/park").then((data) => {
      this.setState({park_open: true});
      this.setState({rampaging: false});
    })
  }

  changeParkOpen() {
    if(this.state.park_open === true){
      this.setState({park_open: false});
      // const request = new Request();
      // request.patch('/park' + this.props.open, false).then(() => {
      // window.location = '/park' + this.props.open
    // })
    }
    else{
      this.setState({park_open: true});
      // const request = new Request();
      // request.patch('/park' + this.props.open, true).then(() => {
      // window.location = '/park' + this.props.open
    // })
  }
}

  changeRampageStatus(){
    if(this.state.rampaging === true){
      this.setState({rampaging: false});
    }
    else{
      this.setState({rampaging: true});
    }
  }

  render() {
    return (
        <>
          <div id = "park_status">
            <p>Current Park Status</p>
            <p>Park Open/ Closed</p>
            <div className ="parkStatus"><ParkBoxStatus status ={this.state.park_open}/></div>
            <button onClick={this.changeParkOpen}>Change Status</button>
            <p>Rampage Status</p>
            <div className ="parkStatus"><RampageBoxStatus status ={this.state.rampaging}/></div>
            <button onClick={this.changeRampageStatus}>Change Status</button>
          </div>
        </>
    );
  }
}

export default ParkStatus;
