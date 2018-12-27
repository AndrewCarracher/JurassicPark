import React, { Component } from 'react';
import AddDino from './dinosaur_view/add_dino';
import RemoveDino from './dinosaur_view/remove_dino';
import TransferDino from './dinosaur_view/transfer_dino';
import Request from '../helpers/request';

class DinosaurView extends Component {
  constructor(props){
    super(props)
    this.handleDinosaurSubmit = this.handleDinosaurSubmit.bind(this);
  }

  handleDinosaurSubmit(newDino){
    if(newDino){
      console.log(newDino);
      const request = new Request();
      request.post("/paddocks/add_dino", newDino).then(() => {
          window.location = "/paddocks"
      })
    }
  }

render(){
  return(
    <>
      <h2>Dinosaur View</h2>
      <AddDino handleDinosaurSubmit = {this.handleDinosaurSubmit}/>
      <RemoveDino />
      <TransferDino />
    </>
  );
}
}

export default DinosaurView;
