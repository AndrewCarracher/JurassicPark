import React, { Component } from 'react';
import PaddockStatus from './park_view/PaddockStatus';
import ParkStatus from '../components/park_view/ParkStatus';
import RampageStatus from '../components/park_view/RampageStatus';
import Request from '../helpers/request';
import VisitorCount from '../components/park_view/VisitorCount';

class ParkView extends Component {
  constructor(props){
    super(props)
    this.state = {parkOpen: [], rampaging: [], visitorCount: [], capacity: 15000}
    this.handleVisitorAdd = this.handleVisitorAdd.bind(this);
    this.handleStatusChange = this.handleStatusChange.bind(this);
    this.handleRampageStatusChange = this.handleRampageStatusChange.bind(this);
  }

  componentDidMount(){
    const request = new Request();
    request.get("/park").then((data) => {
        this.setState({parkOpen: data[0].parkOpen});
        this.setState({rampaging: data[0].rampage});
        this.setState({visitorCount: data[0].visitorCount});
        this.setState({capacity: data[0].capacity});
    })
  }

  handleVisitorAdd(event){
    if(event){
      if(this.state.rampaging === false && this.state.parkOpen === true){
        if(this.state.visitorCount +1 < this.state.capacity){
          let newVisitorCount = this.state.visitorCount +1;
          this.setState({
            visitorCount: newVisitorCount
          })
        }
      }
    }
  }

  handleStatusChange(event){
    if(event){
      if(this.state.parkOpen){
        this.setState({parkOpen: false, visitorCount: 0})
      }else{
        this.setState({parkOpen: true})
      }
    }
  }

  handleRampageStatusChange(event){
    if(event){
      if(this.state.rampaging){
        this.setState({rampaging: false})
      }else{
        this.setState({rampaging: true})
      }
    }
  }


  render() {
    return (
        <>
          <h2>ParkView</h2>
          <div id="park_info">
          <VisitorCount onClick={this.handleVisitorAdd} visitorCount ={this.state.visitorCount} capacity = {this.state.capacity} />
          <ParkStatus onClick = {this.handleStatusChange} parkOpen = {this.state.parkOpen} />
          <RampageStatus onClick = {this.handleRampageStatusChange} rampaging = {this.state.rampaging} />
          </div>
          <PaddockStatus />
        </>
    );
  }
}

export default ParkView;
