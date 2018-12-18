import React, { Component } from 'react';
import PaddockBoxView from '../components/paddock_view/paddock_box_view.js';
import Request from '../helpers/request';

class PaddockView extends Component {
  constructor(props){
    super(props)
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
        console.log(this.state);
    })
  }

render(){
  return(
    <>
      <h2>Paddock View</h2>
        <div id="overall_paddock_view">
          <PaddockBoxView paddock = {this.state.paddock1}/>
          <PaddockBoxView paddock = {this.state.paddock2}/>
          <PaddockBoxView paddock = {this.state.paddock3}/>
          <PaddockBoxView paddock = {this.state.paddock4}/>
          <PaddockBoxView paddock = {this.state.paddock5}/>
          <PaddockBoxView paddock = {this.state.paddock6}/>
        </div>
    </>
  );
}
}

export default PaddockView;
