import React, { Component } from 'react';
import Request from '../../helpers/request';
import PaddockBoxStatus from '../../components/park_view/PaddockBoxStatus';

class PaddockStatus extends Component {
  constructor(props){
    super(props);
    this.state = {
      paddock1: [], paddock2: [], paddock3: [], paddock4: [], paddock5: [], paddock6: []
    }
  }

  componentDidMount(){
    const request = new Request();
    request.get("/paddocks/all").then((data) => {
        this.setState({paddock1: data[0]});
        this.setState({paddock2: data[5]});
        this.setState({paddock3: data[4]});
        this.setState({paddock4: data[3]});
        this.setState({paddock5: data[2]});
        this.setState({paddock6: data[1]});
    })
  }

  render() {
      return(
        <>
        <div id = "paddock_box_overview">
          <div className= "paddock_box">
            <PaddockBoxStatus paddocks = {this.state.paddock1}/>
          </div>
          <div className= "paddock_box">
            <PaddockBoxStatus paddocks = {this.state.paddock2}/>
          </div>
          <div className= "paddock_box">
            <PaddockBoxStatus paddocks = {this.state.paddock3}/>
          </div>
          <div className= "paddock_box">
            <PaddockBoxStatus paddocks = {this.state.paddock4}/>
          </div>
          <div className= "paddock_box">
            <PaddockBoxStatus paddocks = {this.state.paddock5}/>
          </div>
          <div className= "paddock_box">
            <PaddockBoxStatus paddocks = {this.state.paddock6}/>
          </div>
          </div>
        </>
    );
  }
}

export default PaddockStatus;
