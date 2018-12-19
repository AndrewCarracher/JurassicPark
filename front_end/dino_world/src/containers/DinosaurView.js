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
    const request = new Request();
    console.log(newDino);
    let requestString = this.props.name + "/" + this.props.age + "/" + this.props.species + "/" + this.props.fed + "/" + this.props.eats_meat;

    request.post("paddocks/add_new_dinosaur/" + requestString, newDino).then(() => {
      window.location = "/paddocks"
    })
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
