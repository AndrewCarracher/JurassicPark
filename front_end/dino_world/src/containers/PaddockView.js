import React, { Component } from 'react';
import PaddockBoxView from '../components/paddock_view/paddock_box_view.js';
import Request from '../helpers/request';
import IndividualPaddock from './paddock_view/individual_paddock';

class PaddockView extends Component {
  constructor(props){
    super(props)
    this.state = {
      paddock1: [], paddock2: [], paddock3: [], paddock4: [], paddock5: [], paddock6: [], paddockView: []
    }
    this.handleEventListener1 = this.handleEventListener1.bind(this);
    this.handleEventListener2 = this.handleEventListener2.bind(this);
    this.handleEventListener3 = this.handleEventListener3.bind(this);
    this.handleEventListener4 = this.handleEventListener4.bind(this);
    this.handleEventListener5 = this.handleEventListener5.bind(this);
    this.handleEventListener6 = this.handleEventListener6.bind(this);
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


        this.click1.addEventListener("click", this.handleEventListener1);
        this.click2.addEventListener("click", this.handleEventListener2);
        this.click3.addEventListener("click", this.handleEventListener3);
        this.click4.addEventListener("click", this.handleEventListener4);
        this.click5.addEventListener("click", this.handleEventListener5);
        this.click6.addEventListener("click", this.handleEventListener6);
    })
  }

  handleEventListener1 = (event) =>{
    this.setState({paddockView: "paddock1"})
  }

  handleEventListener2 = (event) =>{
    this.setState({paddockView: "paddock2"})
  }

  handleEventListener3 = (event) =>{
    this.setState({paddockView: "paddock3"})
  }

  handleEventListener4 = (event) =>{
    this.setState({paddockView: "paddock4"})
  }

  handleEventListener5 = (event) =>{
    this.setState({paddockView: "paddock5"})
  }

  handleEventListener6 = (event) =>{
    this.setState({paddockView: "paddock6"})
  }

render(){
  if(this.state.paddockView.length > 0){
    return(
      <IndividualPaddock paddock = {this.state.paddockView} />
    );
  }

  return(
    <>
      <h2>Paddock View</h2>
        <div id="overall_paddock_view">
            <div className = "paddock_box" ref ={elem => this.click1 = elem}>
              <PaddockBoxView paddock = {this.state.paddock1} />
            </div>
            <div className = "paddock_box" ref ={elem => this.click2 = elem}>
              <PaddockBoxView paddock = {this.state.paddock2} />
            </div>
            <div className = "paddock_box" ref ={elem => this.click3 = elem}>
              <PaddockBoxView paddock = {this.state.paddock3} />
            </div>
            <div className = "paddock_box" ref ={elem => this.click4 = elem}>
              <PaddockBoxView paddock = {this.state.paddock4} />
            </div>
            <div className = "paddock_box" ref = {elem => this.click5 = elem}>
              <PaddockBoxView paddock = {this.state.paddock5} />
            </div>
            <div className = "paddock_box" ref ={elem => this.click6 = elem}>
              <PaddockBoxView paddock = {this.state.paddock6} />
            </div>
        </div>
    </>
  );
}
}

export default PaddockView;
