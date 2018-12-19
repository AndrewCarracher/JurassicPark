import React, { Component } from 'react';
import Request from '../../helpers/request';
import PetList from '../../components/paddock_view/pet_list';

class IndividualPaddock extends Component {
  constructor(props){
    super(props);
    this.state = {
      paddock: [],
      fed:[]
    }
    this.handleFeedDino = this.handleFeedDino.bind(this);
  }

  componentDidMount(){
    const request = new Request();
    request.get("/paddocks/all").then((data) => {
        for(let i = 0; i < data.length; i++){
          if(this.props.paddock === data[i].name){
            this.setState({paddock: data[i]});
          }
        }
        this.setState({fed: "Not Fed"})
      })
    }

    handleFeedDino(){
      if(this.state.paddock){
        if(this.state.fed === "Not Fed"){
          this.setState({fed: "Fed"})
        }
      }
    }

  render(){
    if(this.state.paddock.occupants && this.state.fed){
      return(
        <>
          <div id= "pen_deets">
            <p>{this.state.paddock.name}</p>
            <p>{this.state.paddock.occupants.length} / {this.state.paddock.capacity}</p>
          </div>
          <div id= "dino_list">
            <PetList list = {this.state.paddock} fed = {this.state.fed}/>
            <button onClick={this.handleFeedDino}>Feed The Dinos</button>
          </div>
        </>
      );
    }
    return(
      <>
          <p>{this.state.paddock.name}</p>
          <p>0 / {this.state.paddock.capacity}</p>
      </>
    );
  }
}

export default IndividualPaddock;
