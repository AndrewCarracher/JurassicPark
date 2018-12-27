import React, { Component } from 'react';
import AddDino from './dinosaur_view/add_dino';
import RemoveDino from './dinosaur_view/remove_dino';
import TransferDino from './dinosaur_view/transfer_dino';
import Request from '../helpers/request';

class DinosaurView extends Component {
  constructor(props){
    super(props)
    this.handleDinosaurSubmit = this.handleDinosaurSubmit.bind(this);
    this.handleDinosaurRemove = this.handleDinosaurRemove.bind(this);
  }

  handleDinosaurSubmit(newDino){
    if(newDino){
      const request = new Request();
      request.post("/paddocks/add_dino", newDino).then(() => {
          window.location = "/paddocks"
      })
    }
  }

  handleDinosaurRemove(deadDino){
    console.log("yo");
    if(deadDino){
      const request = new Request();
      request.delete("/paddocks/kill_dino/" + deadDino).then(() => {
          // window.location = "/paddocks"
      })
    }
  }

render(){
  return(
    <>
      <h2>Dinosaur View</h2>
      <AddDino handleDinosaurSubmit = {this.handleDinosaurSubmit}/>
      <RemoveDino handleDinosaurRemove = {this.handleDinosaurRemove}/>
      <TransferDino />
    </>
  );
}
}

export default DinosaurView;
